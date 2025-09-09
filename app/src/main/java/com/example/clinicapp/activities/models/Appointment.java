package com.example.clinicapp.activities.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "appointments")
public class Appointment {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String doctor;
    private String date;
    private int userId;

    public Appointment(String doctor, String date, int userId) {
        this.doctor = doctor;
        this.date = date;
        this.userId = userId;
    }

    public Appointment() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDoctor() { return doctor; }
    public void setDoctor(String doctor) { this.doctor = doctor; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}
