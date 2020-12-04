package com.example.miniprojetandroid.ui.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.miniprojetandroid.R;
import com.example.miniprojetandroid.models.Bike;
import com.example.miniprojetandroid.models.Location;
import com.example.miniprojetandroid.models.User;

import org.w3c.dom.Text;


public class RentDetailsFragment extends Fragment {

    Button btnDelete;
    TextView txtDatelocation, txtAdresselocation, txtHours, txtTotalprice, txtBikemodel,txtBiketype,txtBikeprice;

    public RentDetailsFragment() {
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
        View v = inflater.inflate(R.layout.fragment_rent_details, container, false);
        // Inflate the layout for this fragment
           btnDelete = v.findViewById(R.id.btnDelete);
           txtDatelocation = v.findViewById(R.id.datelocation);
           txtAdresselocation = v.findViewById(R.id.adresselocation);
           txtBikemodel = v.findViewById(R.id.bikemodel);
           txtBiketype = v.findViewById(R.id.biketype);
           txtBikeprice = v.findViewById(R.id.bikeprice);

           Bike bike;
           User user = new User();
        Location rent;
        int id = getArguments().getInt("location_id");
        int userid = getArguments().getInt("user_id");
        int bikeid = getArguments().getInt("bike_id");
        String model = getArguments().getString("model");
        String type = getArguments().getString("type");
        Log.e("type",type);
        String price = getArguments().getString("price");
        String datelocation = getArguments().getString("datelocation");
        String adresselocation = getArguments().getString("adresselocation");
        int image = getArguments().getInt("image");
        bike = new Bike(bikeid,model,type,price,image);
        user.setId(userid);
        rent = new Location(adresselocation, "22", bike, user);
        rent.setDateLocation(datelocation);

        Log.e("ddddddddd",bike.toString());

        txtDatelocation.setText("Date de Location :       "+rent.getDateLocation());
        txtAdresselocation.setText("Adresse de Location :       "+rent.getAddressLocation());
        txtBikemodel.setText("Bike Model :     "+rent.getBike().getModel());
        txtBiketype.setText("Bike Type :          "+rent.getBike().getType());
        txtBikeprice.setText("Bike price per hour:   "+rent.getBike().getPrice()+"  DT");


        return v;
    }



}