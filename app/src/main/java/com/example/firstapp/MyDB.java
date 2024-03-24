package com.example.firstapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Entity2.class,exportSchema = false,version = 1)
public abstract class MyDB extends RoomDatabase {
    private static final String DB_NAME = "myDB";
    private static MyDB instance;
    public static synchronized MyDB getDB(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context,MyDB.class,DB_NAME)
                    .fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract EntityDao entityDao();
}

