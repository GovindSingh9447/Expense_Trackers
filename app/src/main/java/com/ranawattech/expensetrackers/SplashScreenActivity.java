package com.ranawattech.expensetrackers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH = 5000;
    Animation animation;
    private TextView appName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_splash_screen);

        animation = AnimationUtils.loadAnimation(this, R.anim.animation);


        appName = findViewById(R.id.appName);


        appName.setAnimation(animation);

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
               startActivity(intent);
               finish();
           }
       }, SPLASH);
    }
}