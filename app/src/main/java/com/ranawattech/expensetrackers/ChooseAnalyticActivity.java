package com.ranawattech.expensetrackers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ChooseAnalyticActivity extends AppCompatActivity {
    private CardView todayCardView, weekCardView, monthCardView;
    private ImageView backbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_analytic);

        todayCardView = findViewById(R.id.todayCardView);
        weekCardView = findViewById(R.id.weekCardView);
        monthCardView = findViewById(R.id.monthCardView);

        backbtn=findViewById(R.id.backbtn);


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        todayCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseAnalyticActivity.this, DailyAnalyticsActivity.class);
                startActivity(intent);
            }
        });

        weekCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseAnalyticActivity.this, WeeklyAnalyticsActivity.class);
                startActivity(intent);
            }
        });

        monthCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseAnalyticActivity.this, MonthlyAnalyticsActivity.class);
                startActivity(intent);
            }
        });
    }
}