package com.example.clinicapp.activities.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "records")
public class Record {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String diagnosis;
    private String description;
    private int userId;

    public Record(String diagnosis, String description, int userId) {
        this.diagnosis = diagnosis;
        this.description = description;
        this.userId = userId;
    }

    public Record() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}
