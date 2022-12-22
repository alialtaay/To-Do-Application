package com.example.todoapplication.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.todoapplication.data.entity.Kisiler;

@Database(entities = {Kisiler.class},version = 1)
public abstract class Veritabani extends RoomDatabase {
    public abstract KisilerDao getKisilerDao();

}
