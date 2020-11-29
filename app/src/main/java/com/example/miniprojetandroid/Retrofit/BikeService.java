package com.example.miniprojetandroid.Retrofit;

import com.example.miniprojetandroid.models.Bike;
import com.example.miniprojetandroid.models.User;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BikeService {

    // get bikes
    @GET("bikes/")
    Call<List<Bike>> getBikes();


}
