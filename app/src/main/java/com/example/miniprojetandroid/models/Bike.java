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
    public int image;


    @Ignore
    public Bike(){

    }

    public Bike( String model, int image) {
        this.model = model;
        this.image = image;
    }

    public Bike( String model, String type, int image) {
        this.model = model;
        this.type = type;
        this.image = image;
    }

    @Ignore
    public Bike(int id, String model, String type,  int image) {
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

    public void setImage(int image) {
        this.image = image;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public int getImage() {
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
