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
    @SerializedName("hours")
    @Expose
    public String hours;
    @SerializedName("bike")
    @Expose
    public Bike bike;
    @SerializedName("user")
    @Expose
    public User user;

    @SerializedName("model")
    @Expose
    public String model;

    @SerializedName("type")
    @Expose
    public String  type;
    @SerializedName("price")
    @Expose
    public String price;
    public int getUser_id() {
        return user_id;
    }


    @SerializedName("user_id")
    @Expose
     public int user_id;
    @SerializedName("bike_id")
    @Expose
     public int bike_id;
    @SerializedName("image")
    @Expose
    public String image;

    public Location(){

    }

    public Location(int id, String addressLocation, Bike bike, User user) {
        this.id = id;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        this.dateLocation = formatter.format(calendar.getTime());
        this.addressLocation = addressLocation;
        this.bike = bike;
        this.user = user;
    }

    
    public Location(int id, String addressLocation, Bike bike) {
        this.id = id;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        this.dateLocation = formatter.format(calendar.getTime());
        this.addressLocation = addressLocation;
        this.bike = bike;
    }


    public Location(  String addressLocation, String hours , Bike bike, User user ) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        this.dateLocation = formatter.format(calendar.getTime());
        this.addressLocation = addressLocation;
        this.hours = hours;
        this.bike = bike;
        this.user = user;
    }


    public Location(  String addressLocation, String hours , int bike, int user ) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        this.dateLocation = formatter.format(calendar.getTime());
        this.addressLocation = addressLocation;
        this.hours = hours;
        this.bike_id = bike;
        this.user_id = user;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getAddressLocation() {
        return addressLocation;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBike_id() {
        return bike_id;
    }

    public void setBike_id(int bike_id) {
        this.bike_id = bike_id;
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
                ", hours='" + hours + '\'' +
                ", bike=" + bike +
                ", user=" + user +
                '}';
    }
}
