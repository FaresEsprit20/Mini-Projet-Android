package com.example.miniprojetandroid.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miniprojetandroid.R;
import com.example.miniprojetandroid.Retrofit.BikeService;
import com.example.miniprojetandroid.Retrofit.RetrofitClient;
import com.example.miniprojetandroid.Retrofit.ShopService;
import com.example.miniprojetandroid.adapters.BikesAdapter;
import com.example.miniprojetandroid.adapters.ShopAdapter;
import com.example.miniprojetandroid.models.Bike;
import com.example.miniprojetandroid.models.Shop;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ShopsFragment extends Fragment implements ShopAdapter.Callback{

    private ShopService apiService;
    private RecyclerView recyclerView;
    private List<Shop> shops = new ArrayList<Shop>();
    private ShopAdapter mAdapter;



    public ShopsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_shops, container, false);

        recyclerView = v.findViewById(R.id.recycler_shops);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        apiService = RetrofitClient.getClient().create(ShopService.class);
        mAdapter = new ShopAdapter(getActivity(), (ArrayList<Shop>) shops);
        fillData();
        recyclerView.setAdapter(mAdapter);
        mAdapter.setCallback(this);

        return v;
    }




    public void fillData(){

        Call<List<Shop>> call = apiService.getShops();
        call.enqueue(new Callback<List<Shop>>() {
            @Override
            public void onResponse(Call<List<Shop>> call, Response<List<Shop>> response) {
                if(response.isSuccessful()){
                    shops.addAll(response.body());
                    Log.e("Bike LIST",shops.toString());
                    mAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<List<Shop>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

    }





    @Override
    public void onItemClicked(Shop shop) {

        Bundle bundle = new Bundle();
        bundle.putInt("shop_id",shop.getId());
        Log.e("SHop ID", String.valueOf(shop.getId()));
        bundle.putString("title", shop.getTitle());
        bundle.putDouble("latitude", shop.getLatitude());
        bundle.putDouble("longitude", shop.getLongitude());
        FragmentOne f = new FragmentOne();
        f.setArguments(bundle);
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentsContainer, f )
                .commit();
    }


}