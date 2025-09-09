package com.example.clinicapp.activities.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.clinicapp.activities.models.Doctor;

import java.util.List;

@Dao
public interface DoctorDao {

    @Insert
    long insertDoctor(Doctor doctor);

    @Query("SELECT * FROM doctors WHERE category = :category")
    List<Doctor> getDoctorsByCategory(String category);

    @Query("SELECT * FROM doctors WHERE category = :category")
    LiveData<List<Doctor>> getDoctorsByCategoryLive(String category);

}
