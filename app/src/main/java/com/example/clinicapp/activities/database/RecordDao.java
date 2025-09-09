package com.example.clinicapp.activities.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.clinicapp.activities.models.Record;
import com.example.clinicapp.activities.models.User;

import java.util.List;

@Dao
public interface RecordDao {

    @Insert
    long insertRecord(Record record);

    @Query("SELECT * FROM records WHERE userId = :userId")
    List<Record> getRecordsByUserId(int userId);
    @Query("SELECT * FROM records WHERE userId = :userId")
    LiveData<List<Record>> getRecordsByUserIdLive(int userId);

    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    LiveData<User> getUserByEmailLive(String email);


}
