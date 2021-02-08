package com.example.sqllite_recycler;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    EditText edit_name, edit_mail, edit_pass, edit_repass;
    Button butt_reg;
    TextView txt_header;


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    DatabaseHelping databaseHelping;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        declareView();

        sharedPreferences = getSharedPreferences("userDetails", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        databaseHelping =  new DatabaseHelping(this);


        txt_header.setText("Registration Page");




        butt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog();

            }

        });


    }

    public boolean validationRule() {
        if (edit_name.getText().toString().isEmpty() || edit_mail.getText().toString().isEmpty() || edit_pass.getText().toString().isEmpty()
                || edit_repass.getText().toString().isEmpty()) {
            Toast.makeText(Registration.this, "Credentials cannot be Empty", Toast.LENGTH_SHORT).show();

            return false;
        } else if (!edit_pass.getText().toString().equals(edit_repass.getText().toString())) {
            Toast.makeText(Registration.this, "Password Mismatch", Toast.LENGTH_SHORT).show();
            return false;
        }
        Toast.makeText(Registration.this, "Registration successful", Toast.LENGTH_SHORT).show();

        return true;


    }

    private void declareView() {
        edit_name = findViewById(R.id.edit_name);
        edit_mail = findViewById(R.id.edit_mail);
        edit_pass = findViewById(R.id.edit_pass);
        edit_repass = findViewById(R.id.edit_repass);
        butt_reg = findViewById(R.id.butt_reg);
        txt_header = findViewById(R.id.txt_header);
    }

    public void createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Registration.this);
        View alertview = getLayoutInflater().inflate(R.layout.customizealert, null);


        Button bt1 = alertview.findViewById(R.id.bt1);
        Button bt2 = alertview.findViewById(R.id.bt2);

        builder.setView(alertview);

        final AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validationRule()) {


                    editor.putInt("user_id", 1);
                    editor.putString("name", edit_name.getText().toString().trim());
                    editor.putString("email", edit_mail.getText().toString().trim());
                    editor.putString("password", edit_pass.getText().toString().trim());
                    editor.putString("Re-enter_password", edit_repass.getText().toString().trim());
                    editor.commit();

                    RegisterUserModel model= new RegisterUserModel();
                    model.setName(edit_name.getText().toString().trim());
                    model.setEmail(edit_mail.getText().toString().trim());
                    model.setPassword(edit_pass.getText().toString().trim());

                    databaseHelping.registerUser(model);


                    Intent intent = new Intent(Registration.this, MainActivity.class);
                    startActivity(intent);
                    finish();


                }


                alertDialog.dismiss();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();

            }
        });

        alertDialog.show();


    }



}