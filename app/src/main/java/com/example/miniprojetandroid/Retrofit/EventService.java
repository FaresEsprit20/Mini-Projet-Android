package com.example.miniprojetandroid.Retrofit;

import com.example.miniprojetandroid.models.Bike;
import com.example.miniprojetandroid.models.Event;
import com.example.miniprojetandroid.models.Participants;
import com.example.miniprojetandroid.models.Shop;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EventService {

    //add a record
    @POST("events/add")
    Call<ResponseBody> addEvent(@Body Event evt);

    //add a record
    @POST("participate")
    Call<ResponseBody> participate(@Body Event evt);

   @GET("events/all")
   Call<List<Event>> getEvents();

    @POST("participants/alls")
    Call<List<Participants>> getParticipants(@Body Event e);



}
