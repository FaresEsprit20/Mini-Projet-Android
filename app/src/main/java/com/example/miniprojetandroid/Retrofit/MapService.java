package com.example.miniprojetandroid.Retrofit;


import com.example.miniprojetandroid.models.Bike;
import com.example.miniprojetandroid.models.BikeCyclist;
import com.example.miniprojetandroid.models.Circuit;
import com.example.miniprojetandroid.models.Community;
import com.example.miniprojetandroid.models.Shop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MapService {


    // get shops
    @GET("bikes/")
    Call<List<Shop>> getShops();

    // get communities
    @GET("communities/")
    Call<List<Community>> getCommunities();

    // get cyclists
    @GET("cyclists/")
    Call<List<BikeCyclist>> getCyclists();

    // get circuits
    @GET("circuits/")
    Call<List<Circuit>> getCircuits();



}
