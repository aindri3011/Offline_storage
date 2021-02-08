package com.example.sqllite_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    RecyclerView recycler_1;
    RecyclerAdapter recyclerAdapter;
    ArrayList<UserModel> arrayList=new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    TextView txt_demo,txt_header;
    Button butt_logout;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        recycler_1 = findViewById(R.id.recycler_1);
        butt_logout=findViewById(R.id.butt_logout);
        txt_demo=findViewById(R.id.txt_demo);
        txt_header=findViewById(R.id.txt_header);
        sharedPreferences=getSharedPreferences("userDetails",MODE_PRIVATE);
        editor=sharedPreferences.edit();


        txt_header.setText("List");


        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            txt_demo.setText(bundle.getString("user_name"));

        }


        arrayList = new ArrayList<>();
        arrayList.add(new UserModel("BERLIN", "berlin@yahoo.com", R.mipmap.ic_launcher));
        arrayList.add(new UserModel("TOKYO", "tokyo@gmail.com", R.mipmap.ic_launcher));
        arrayList.add(new UserModel("RIO", "rio@gmail.com", R.mipmap.ic_launcher));
        arrayList.add(new UserModel("MOSCOW", "moscow@gmail.com", R.mipmap.ic_launcher));
        arrayList.add(new UserModel("NAIROBI", "nairobi@gmail.com", R.mipmap.ic_launcher));
        arrayList.add(new UserModel("DENVER", "denver@gmail.com", R.mipmap.ic_launcher));
        arrayList.add(new UserModel("HELSENKI", "heilsenki@gmail.com", R.mipmap.ic_launcher));
        arrayList.add(new UserModel("OSLO","olso@gmail.com",R.mipmap.ic_launcher));

        linearLayoutManager = new LinearLayoutManager(Dashboard.this,RecyclerView.VERTICAL, false);
        recyclerAdapter= new RecyclerAdapter(arrayList, Dashboard.this);
        recycler_1.setLayoutManager(linearLayoutManager);
        recycler_1.setAdapter(recyclerAdapter);

        butt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             editor.clear();
             editor.apply();

                Intent intent=new Intent(Dashboard.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });





    }

}