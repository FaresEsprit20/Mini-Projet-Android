package com.example.miniprojetandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Location {

    @SerializedName("location_id")
    @Expose
   public int id;
    @SerializedName("datelocation")
    @Expose
    public String dateLocation;
    @SerializedName("adresselocation")
    @Expose
    public String addressLocation;
    @SerializedName("bike")
    @Expose
    public Bike bike;
    @SerializedName("user_id")
    @Expose
    public User user;

    public Location(){

    }

    public Location(int id, String addressLocation, Bike bike, User user) {
        this.id = id;
        Date currentTime = Calendar.getInstance().getTime();
        this.dateLocation = currentTime.toString();
        this.addressLocation = addressLocation;
        this.bike = bike;
        this.user = user;
    }

    
    public Location(int id, String addressLocation, Bike bike) {
        this.id = id;
        Date currentTime = Calendar.getInstance().getTime();
        this.dateLocation = currentTime.toString();
        this.addressLocation = addressLocation;
        this.bike = bike;
    }


    public Location(  String addressLocation, Bike bike) {
        Date currentTime = Calendar.getInstance().getTime();
        this.dateLocation = currentTime.toString();
        this.addressLocation = addressLocation;
        this.bike = bike;
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
