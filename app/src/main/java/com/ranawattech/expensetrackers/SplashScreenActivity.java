package com.ranawattech.expensetrackers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH = 5000;
    Animation animation;
    private TextView appName;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        animation = AnimationUtils.loadAnimation(this, R.anim.animation);


        appName = findViewById(R.id.appName);


        appName.setAnimation(animation);
        //init firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkUser();

            }
        }, SPLASH);
    }


        //    Intent intent=new Intent( SplashScreen.this, PromoActivity.class);
//    startActivity(intent);
//    finish();

        private void checkUser() {
            //get current user, if login
            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
            if (firebaseUser == null) {

                //user not logged in
                //start main screen
                startActivity(new Intent(SplashScreenActivity.this, SecondScreen.class));
            } else {
                //user loggin check user type same as done in login screen

                //check in db
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
                reference.child(firebaseUser.getUid())
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {


//                            //get user type
//                            String userType= ""+snapshot.child("userType").getValue();


                                //this is the simple user open the user Dashboard
                                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                                finish();


                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
            }
        }

}

