package com.example.clinicapp.activities.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.clinicapp.activities.models.Appointment;

import java.util.List;

@Dao
public interface AppointmentDao {

    @Insert
    long insert(Appointment appointment);

    @Query("SELECT * FROM appointments WHERE userId = :userId")
    List<Appointment> getAppointmentsByUserId(int userId);

    @Query("SELECT * FROM appointments WHERE userId = :userId")
    LiveData<List<Appointment>> getAppointmentsByUserIdLive(int userId);

}
