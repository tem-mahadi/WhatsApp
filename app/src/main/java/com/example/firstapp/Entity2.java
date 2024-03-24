package com.example.firstapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Entity2")
public class Entity2 {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String username;
    private String password;

    public Entity2(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
