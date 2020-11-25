package com.example.miniprojetandroid.ui.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.miniprojetandroid.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.miniprojetandroid.R;
import com.example.miniprojetandroid.adapters.BikesAdapter;
import com.example.miniprojetandroid.models.Bike;

public class FragmentOne extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Bike> bikes = new ArrayList<Bike>();
    private  BikesAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_one, container,false);

        recyclerView = rootView.findViewById(R.id.recycler_bikes);

        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));

        fillData();

        mAdapter = new BikesAdapter(getActivity(), bikes);

        recyclerView.setAdapter(mAdapter);

        return rootView;
    }

    public void fillData(){
       bikes.add(new Bike(1,"ECO", "RTT" , R.drawable.ruebike ));
        bikes.add(new Bike(2,"AAA", "RTT" , R.drawable.ruebike ));
        bikes.add(new Bike(3,"BBB", "RUE" , R.drawable.ruebike ));
        bikes.add(new Bike(4,"EEE", "SPORT" , R.drawable.ruebike ));
        bikes.add(new Bike(5,"CCC", "SPORT" , R.drawable.ruebike ));

    }
}
