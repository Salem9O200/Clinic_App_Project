package com.example.clinicapp.activities.services;

import android.app.IntentService;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.example.clinicapp.activities.utils.NotificationHelper;

public class ReminderService extends IntentService {

    public ReminderService() {
        super("ReminderService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String message = intent.getStringExtra("message");

            NotificationHelper notificationHelper = new NotificationHelper(this);
            notificationHelper.sendNotification(title != null ? title : "Reminder",
                    message != null ? message : "You have an upcoming appointment!");
        }
    }
}
