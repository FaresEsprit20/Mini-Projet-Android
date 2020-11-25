package com.example.miniprojetandroid.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.miniprojetandroid.dao.UserDAO;
import com.example.miniprojetandroid.models.User;


@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract UserDAO userDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "room_database")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

}

