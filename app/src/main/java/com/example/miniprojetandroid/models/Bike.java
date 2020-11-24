package com.example.miniprojetandroid.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "bikes")
public class Bike {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo( name ="model")
    public String model;
    @ColumnInfo( name ="type")
    public String  type;
    @ColumnInfo( name ="image")
    public String image;


    @Ignore
    public Bike(){

    }


    public Bike( String model, String type, String image) {
        this.model = model;
        this.type = type;
        this.image = image;
    }

    @Ignore
    public Bike(int id, String model, String type, String image) {
        this.id = id;
        this.model = model;
        this.type = type;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                '}';
    }



}
