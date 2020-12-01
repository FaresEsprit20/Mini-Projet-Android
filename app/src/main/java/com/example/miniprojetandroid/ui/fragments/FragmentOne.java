package com.example.miniprojetandroid.ui.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.miniprojetandroid.R;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miniprojetandroid.Retrofit.BikeService;
import com.example.miniprojetandroid.Retrofit.RetrofitClient;
import com.example.miniprojetandroid.Retrofit.UserService;
import com.example.miniprojetandroid.adapters.BikesAdapter;
import com.example.miniprojetandroid.models.Bike;
import com.example.miniprojetandroid.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentOne extends Fragment {

    private BikeService apiService;

    private RecyclerView recyclerView;
    private List<Bike> bikes = new ArrayList<Bike>();
    private  BikesAdapter mAdapter;
    List<Bike> result = new ArrayList<Bike>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_one, container,false);

        recyclerView = rootView.findViewById(R.id.recycler_bikes);

        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));

        apiService = RetrofitClient.getClient().create(BikeService.class);
        fillData();



        return rootView;
    }


    public void fillData(){


        Call<List<Bike>> call = apiService.getBikes();
        call.enqueue(new Callback<List<Bike>>() {
            @Override
            public void onResponse(Call<List<Bike>> call, Response<List<Bike>> response) {
                if(response.isSuccessful()){
                    bikes.addAll(response.body());
                    for(Bike bike: bikes){
                        bike.setImage(R.drawable.ruebike);
                    }
                    Log.e("Bike LIST", bikes.toString());
                    mAdapter = new BikesAdapter(getActivity(), (ArrayList<Bike>) bikes);

                    recyclerView.setAdapter(mAdapter);

                    //listView.setAdapter(new UserAdapter(MainActivity.this, R.layout.list_user, list));
                }
            }
            @Override
            public void onFailure(Call<List<Bike>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });




        /*bikes.add(new Bike(1,"ECO", "RTT" , "44", R.drawable.ruebike ));
        bikes.add(new Bike(2,"AAA", "RTT" , "33",  R.drawable.ruebike ));
        bikes.add(new Bike(3,"BBB", "RUE" , "11",  R.drawable.ruebike ));
        bikes.add(new Bike(4,"EEE", "SPORT" , "25",  R.drawable.ruebike ));
        bikes.add(new Bike(5,"CCC", "SPORT" , "77", R.drawable.ruebike ));
        Log.e("USERS LIST", bikes.toString());*/
    }
}