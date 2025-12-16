package com.example.a4zad;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class EveningActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "sleep_channel";
    private static final int NOTIFICATION_ID = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evening);

        ImageView eveningImage = findViewById(R.id.evening_image);
        eveningImage.setImageResource(R.drawable.evening);

        sendSleepNotification();

        findViewById(R.id.btn_back).setOnClickListener(v -> {
            finish();
        });

        findViewById(R.id.btn_next).setOnClickListener(v -> {
            Intent intent = new Intent(EveningActivity.this, NightActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void sendSleepNotification() {
        createNotificationChannel();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
                .setContentTitle("Вечернее время")
                .setContentText("Пора спать!")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID, builder.build());
        }
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Sleep Notifications";
            String description = "Evening sleep reminders";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{0, 500, 200, 500});
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }
    }
}