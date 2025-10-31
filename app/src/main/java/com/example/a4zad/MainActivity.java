package com.example.a4zad;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_morning).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MorningActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_day).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DayActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_evening).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EveningActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_night).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NightActivity.class);
            startActivity(intent);
        });
    }
}