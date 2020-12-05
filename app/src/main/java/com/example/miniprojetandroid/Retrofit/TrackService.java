package com.example.miniprojetandroid.Retrofit;

import com.example.miniprojetandroid.models.Location;
import com.example.miniprojetandroid.models.Record;
import com.example.miniprojetandroid.models.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;


public interface TrackService {

    //add a record
    @POST("records/add")
    Call<ResponseBody> addRecord(@Body Record record);

    //add a record
    @POST("records/get")
    Call<List<Record>> getRecords(@Body User user);

    //add a record
    @POST("records/delete")
    Call<ResponseBody> deleteRecord(@Body Record record);



}
