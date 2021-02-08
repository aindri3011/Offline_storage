package com.example.sqllite_recycler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelping extends SQLiteOpenHelper {
    public  static final  String dbName = "userAccount.db";

    public  static final  int dbVersion = 1;

    public  static final   String tableName="userTable";

    public  static final String column_Id="user_id";
    public  static final String column_Name="user_name";
    public  static final String column_Email="user_email";
    public  static final String column_Password="user_password";

    Context context;
    public DatabaseHelping(@Nullable Context context){
        super(context , dbName , null,  dbVersion);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+tableName+" ("+column_Id+" integer primary key autoincrement, "+column_Name +" text, "+column_Email +" varchar, "+column_Password +" varchar)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+tableName);

    }
    public void  registerUser(RegisterUserModel registerUserModel){
        SQLiteDatabase db= getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_Name,registerUserModel.getName());
        contentValues.put(column_Email,registerUserModel.getEmail());
        contentValues.put(column_Password,registerUserModel.getPassword());

       db.insert(tableName,null,contentValues);
       db.close();

    }
    public  boolean loginUser(String email, String password){
        String[]  columns = {column_Id};
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = column_Email + " = ? " + " AND " + column_Password + " = ? ";

        String[]  selectionArgs =  {email,password};

        Cursor cursor=db.query(tableName, columns, selection, selectionArgs, null, null, null);
        int cursorCount = cursor.getCount();
        db.close();

        if(cursorCount > 0){
            return  true;
        }
        return  false;



    }


}
