package com.example.miniprojetandroid.Retrofit;

import com.example.miniprojetandroid.models.Bike;
import com.example.miniprojetandroid.models.Shop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ShopService {

    // get shops
    @GET("shops/")
    Call<List<Shop>> getShops();


}
