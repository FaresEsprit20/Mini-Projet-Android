package com.example.miniprojetandroid.Retrofit;
import com.example.miniprojetandroid.models.Bike;
import com.example.miniprojetandroid.models.User;

import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface UserService {


    @POST("register/")
    Call<ResponseBody> createUser(@Body User user);

    @POST("login/")
    Call<User> loginUser(@Body User user);

    @GET("user/get")
    Call<User> getUser(@Query("email") String email);

    // get bikes
    @GET("users")
    Call<List<User>> getUsers();

    // update user
    @PUT("user/update")
    Call<ResponseBody> updateUser(
            @Body User user
    );


}

