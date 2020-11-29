package com.example.miniprojetandroid.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Location {

   public int id;

    public String dateLocation;

    public String addressLocation;

    public Bike bike;

    public User user;

    public Location(){

    }

    public Location(String addressLocation, Bike bike, User user) {
        Date currentTime = Calendar.getInstance().getTime();
        this.dateLocation = currentTime.toString();
        this.addressLocation = addressLocation;
        this.bike = bike;
        this.user = user;
    }


    public Location(  String addressLocation, Bike bike) {
        Date currentTime = Calendar.getInstance().getTime();
        this.dateLocation = currentTime.toString();
        this.addressLocation = addressLocation;
        this.bike = bike;
    }



    public Location( String dateLocation, String addressLocation, Bike bike, User user) {
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
