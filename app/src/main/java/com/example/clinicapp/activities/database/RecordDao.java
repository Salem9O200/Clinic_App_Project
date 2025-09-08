package com.example.clinicapp.activities.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.clinicapp.activities.models.Record;

import java.util.List;

@Dao
public interface RecordDao {

    @Insert
    long insertRecord(Record record);

    @Query("SELECT * FROM records WHERE userId = :userId")
    List<Record> getRecordsByUserId(int userId);
}
