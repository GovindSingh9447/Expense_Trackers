package com.ranawattech.expensetrackers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class SecondScreen extends AppCompatActivity {

    private MaterialButton goRegister,goLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        goRegister = findViewById(R.id.signups2);
        goLogin = findViewById(R.id.logins2);

        goRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondScreen.this,RegistrationActivity.class));
            }
        });

        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondScreen.this,LoginActivity.class));
            }
        });


    }
}