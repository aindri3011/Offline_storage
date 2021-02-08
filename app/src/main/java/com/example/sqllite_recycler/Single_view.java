package com.example.sqllite_recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Single_view extends AppCompatActivity {
    TextView text_1,text_2;
    ImageView image_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view);
        text_1=findViewById(R.id.text_1);
        text_2=findViewById(R.id.text_2);
        image_1=findViewById(R.id.image_1);
    }
}