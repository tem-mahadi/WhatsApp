package com.example.firstapp;

import android.text.BoringLayout;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EntityDao {
    @Insert
    void insert(Entity2 user);
    @Query("SELECT EXISTS ( SELECT * FROM ENTITY2 WHERE username = :name)")
    Boolean is_taken(String name);
    @Query(" select exists ( select * from Entity2 where username = :name and password= :pass )")
    Boolean is_exist(String name, String pass);
    @Query("DELETE FROM Entity2")
    void deleteAll();
    @Query("delete from entity2 where username= :name and password= :pass")
    void deleteUser(String name, String pass);
    @Query("update entity2 set username = :name, password= :pass")
    void updateUser(String name, String pass);
    @Query("select * from entity2")
    List<Entity2> getAllUsers();
}
