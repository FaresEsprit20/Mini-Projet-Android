package com.example.miniprojetandroid.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miniprojetandroid.R;

import com.example.miniprojetandroid.adapters.RentsAdapter;
import com.example.miniprojetandroid.models.Bike;
import com.example.miniprojetandroid.models.Location;

import java.util.ArrayList;


public class FragmentTwo extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Bike> bikes = new ArrayList<Bike>();
    private ArrayList<Location> locations = new ArrayList<Location>();
    private RentsAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_two, container,false);

        recyclerView = rootView.findViewById(R.id.recycler_rents);

        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));

        fillData();

        mAdapter = new RentsAdapter(getActivity(), locations);

        recyclerView.setAdapter(mAdapter);

        return rootView;
    }

    public void fillData(){
      Bike b1 = new Bike(1,"ECO", "RTT" , R.drawable.ruebike );
       Bike b2 = new Bike(2,"AAA", "Sport" , R.drawable.ruebike );
        locations.add(new Location("25/11/2020","Marsa", b1));
        locations.add(new Location("24/11/2020","Bizerte", b2));

    }


}