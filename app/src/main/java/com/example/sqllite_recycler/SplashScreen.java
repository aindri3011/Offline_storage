package com.example.sqllite_recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    TextView welcome_sc,user_sc;
    ImageView icon_sc;
    Animation top_anim,bottom_anim,rotate_anim;

    public static final int timer =4300;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        welcome_sc=findViewById(R.id.welcome_sc);
        icon_sc=findViewById(R.id.icon_sc);
        user_sc=findViewById(R.id.user_sc);

        top_anim=AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottom_anim=AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        rotate_anim=AnimationUtils.loadAnimation(this,R.anim.rotate_anim);

      welcome_sc.setAnimation(top_anim);
      icon_sc.setAnimation(bottom_anim);
      user_sc.setAnimation(rotate_anim);





        sharedPreferences = getSharedPreferences("userDetails",MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(sharedPreferences.getInt("user_id",0)>0){
                    Intent intent=new Intent(SplashScreen.this,Dashboard.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        } ,timer);


        }
}