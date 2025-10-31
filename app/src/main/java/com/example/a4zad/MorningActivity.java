package com.example.a4zad;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MorningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning);

        ImageView morningImage = findViewById(R.id.morning_image);
        morningImage.setImageResource(R.drawable.morning);

        findViewById(R.id.btn_back).setOnClickListener(v -> {
            finish();
        });

        findViewById(R.id.btn_next).setOnClickListener(v -> {
            Intent intent = new Intent(MorningActivity.this, DayActivity.class);
            startActivity(intent);
            finish();
        });
    }
}