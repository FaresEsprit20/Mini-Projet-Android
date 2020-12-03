package com.example.miniprojetandroid.Retrofit;
import com.example.miniprojetandroid.models.Bike;
import com.example.miniprojetandroid.models.Location;
import com.example.miniprojetandroid.models.User;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;


public interface RentService {


    //add a rent
    @POST("locations/add")
    Call<ResponseBody> addRent(@Body Location location);


    // get rents
    @GET("locations/")
    Call<List<Location>> getRents(@Body User user);


    // delete rent
    @DELETE("locations/delete")
    Call<ResponseBody> deleteRent(
            @Body Location location );


}
