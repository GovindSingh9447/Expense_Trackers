package com.ranawattech.expensetrackers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class GetStart extends AppCompatActivity {

    private MaterialButton goHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_start);


        goHome = findViewById(R.id.home_take);

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(GetStart.this,MainActivity.class));
                finish();
            }
        });
    }
}