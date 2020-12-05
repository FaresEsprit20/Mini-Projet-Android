package com.example.miniprojetandroid.dao;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.miniprojetandroid.models.Bike;

import java.util.List;


@Dao
public interface BikeDao {

    @Query("SELECT * FROM bike_table")
    List<Bike> getAll();

    @Insert
    void insertOne(Bike bike);

    @Delete
    void delete(Bike bike);


}
