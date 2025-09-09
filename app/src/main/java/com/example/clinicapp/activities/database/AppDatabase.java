package com.example.clinicapp.activities.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.clinicapp.activities.models.User;
import com.example.clinicapp.activities.models.Appointment;
import com.example.clinicapp.activities.models.Record;
import com.example.clinicapp.activities.models.Doctor;

@Database(entities = {User.class, Appointment.class, Record.class, Doctor.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract UserDao userDao();
    public abstract AppointmentDao appointmentDao();
    public abstract RecordDao recordDao();
    public abstract DoctorDao doctorDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "clinic_app_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries() // مؤقتًا للسهولة، لاحقًا استخدم Async
                    .build();
        }
        return instance;
    }
}
