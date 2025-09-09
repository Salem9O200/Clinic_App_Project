package com.example.clinicapp.activities.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "doctors")
public class Doctor {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String category;

    public Doctor(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Doctor() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
