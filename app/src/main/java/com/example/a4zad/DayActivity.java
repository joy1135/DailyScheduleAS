package com.example.a4zad;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        findViewById(R.id.btn_back).setOnClickListener(v -> {
            finish();
        });

        findViewById(R.id.btn_next).setOnClickListener(v -> {
            Intent intent = new Intent(DayActivity.this,EveningActivity.class);
            startActivity(intent);
            finish();
        });

        Toast.makeText(this, "Скоро конец рабочего дня!", Toast.LENGTH_LONG).show();
    }
}