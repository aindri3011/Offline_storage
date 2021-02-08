package com.example.sqllite_recycler;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit_email,edit_password;
    Button button_login,button_create;

    SharedPreferences sharedPreferences;
    TextView txt_header;

    DatabaseHelping databaseHelping;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        declareView();
        txt_header.setText("Online Registration");

        sharedPreferences=getSharedPreferences("userDetails",MODE_PRIVATE);

        databaseHelping = new DatabaseHelping(this);



        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean login_verify = databaseHelping.loginUser(edit_email.getText().toString().trim(),
                        edit_password.getText().toString().trim());

                if(login_verify){
                    Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(MainActivity.this,Dashboard.class);
                    intent.putExtra("user_name",sharedPreferences.getString("name",""));
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(MainActivity.this,"Invalid Login",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }


        });







        button_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Registration.class);
                startActivity(intent);
                finish();
            }
        });
    }


    private  void  declareView(){
        edit_email=findViewById(R.id.edit_email);
        edit_password=findViewById(R.id.edit_password);

        button_login=findViewById(R.id.button_login);
        button_create=findViewById(R.id.button_create);

        txt_header=findViewById(R.id.txt_header);
    }



    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert!");
        builder.setMessage("Do to you want to exit?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();

    }

}