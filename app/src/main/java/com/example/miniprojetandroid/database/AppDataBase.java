package com.example.miniprojetandroid.database;


import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.miniprojetandroid.dao.BikeDao;
import com.example.miniprojetandroid.models.Bike;

@Database(entities = {Bike.class}, version = 3, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase instance;

    public abstract BikeDao bikeDao();

    public static AppDataBase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "bike_db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return instance;
    }

}
