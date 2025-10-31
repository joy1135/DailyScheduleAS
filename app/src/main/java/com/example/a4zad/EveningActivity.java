package com.example.a4zad;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EveningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evening);

        ImageView eveningImage = findViewById(R.id.evening_image);
        eveningImage.setImageResource(R.drawable.evening);

        sendSleepToast();

        findViewById(R.id.btn_back).setOnClickListener(v -> {
            finish();
        });

        findViewById(R.id.btn_next).setOnClickListener(v -> {
            Intent intent = new Intent(EveningActivity.this, NightActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void sendSleepToast() {
        Toast.makeText(this, "Пора спать!",
                Toast.LENGTH_LONG).show();
    }
}