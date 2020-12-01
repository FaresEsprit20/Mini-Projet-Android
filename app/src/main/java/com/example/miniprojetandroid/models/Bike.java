package com.example.miniprojetandroid.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bike {

    @SerializedName("bike_id")
    @Expose
    public int id;
    @SerializedName("model")
    @Expose
    public String model;
    @SerializedName("type")
    @Expose
    public String  type;
    @SerializedName("price")
    @Expose
    public String price;

    public int image;


    public Bike(){
    }


    public Bike( String model, int image) {
        this.model = model;
        this.image = image;
    }

    public Bike( String model, String type, String price, int image) {
        this.model = model;
        this.type = type;
        this.price = price;
        this.image = image;
    }

    public Bike(int id, String model, String price, String type) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.type = type;
    }

    public Bike(int id, String model, String type, String price,  int image) {
        this.id = id;
        this.model = model;
        this.type = type;
        this.price = price;
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
                ", price='" + price + '\'' +
                ", image=" + image +
                '}';
    }


}
