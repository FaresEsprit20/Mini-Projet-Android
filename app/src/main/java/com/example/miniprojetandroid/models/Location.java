package com.example.miniprojetandroid.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "locations")
public class Location {

    @PrimaryKey(autoGenerate = true)
   public int id;
    @ColumnInfo( name ="dateLocation")
    public String dateLocation;
    @ColumnInfo( name ="adressLocation")
    public String addressLocation;
    @ColumnInfo( name ="bike")
    public Bike bike;
    @ColumnInfo( name ="user")
    public User user;

    @Ignore
    public Location(){

    }

    public Location( String dateLocation, String addressLocation, Bike bike, User user) {
        this.dateLocation = dateLocation;
        this.addressLocation = addressLocation;
        this.bike = bike;
        this.user = user;
    }

    @Ignore
    public Location( String dateLocation, String addressLocation, Bike bike) {
        this.dateLocation = dateLocation;
        this.addressLocation = addressLocation;
        this.bike = bike;
    }



    @Ignore
    public Location(int id, String dateLocation, String addressLocation, Bike bike, User user) {
        this.id = id;
        this.dateLocation = dateLocation;
        this.addressLocation = addressLocation;
        this.bike = bike;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getDateLocation() {
        return dateLocation;
    }

    public void setAddressLocation(String addressLocation) {
        this.addressLocation = addressLocation;
    }

    public String getAddressLocation() {
        return addressLocation;
    }



    public Bike getBike() {
        return bike;
    }

    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateLocation(String dateLocation) {
        this.dateLocation = dateLocation;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public void setUser(User user) {
        this.user = user;
    }



    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", dateLocation='" + dateLocation + '\'' +
                ", addressLocation='" + addressLocation + '\'' +
                ", bike=" + bike +
                ", user=" + user +
                '}';
    }
}
