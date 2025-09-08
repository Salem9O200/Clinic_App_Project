package com.example.clinicapp.activities.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.clinicapp.activities.models.User;
import com.example.clinicapp.activities.models.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract UserDao userDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "clinic_app_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries() // ⚠️ مبدئيًا لتسهيل التجربة (لاحقًا يفضل Async)
                    .build();
        }
        return instance;
    }
}
