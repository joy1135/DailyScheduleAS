package com.example.a4zad;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_NOTIFICATION = 1001; // Добавляем константу для кода запроса

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

        requestNotificationPermission();
    }

    private void requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.POST_NOTIFICATIONS},
                        REQUEST_CODE_NOTIFICATION);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions,
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE_NOTIFICATION) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {

            }
        }
    }
}