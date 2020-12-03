package com.example.miniprojetandroid.ui.fragments;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.miniprojetandroid.R;
import com.example.miniprojetandroid.models.Bike;
import com.example.miniprojetandroid.models.Location;
import com.example.miniprojetandroid.models.User;


public class RentFragment extends Fragment {

    Button btnRent;
    EditText AdresseLocation, Hours;

    public RentFragment() {
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
        View v = inflater.inflate(R.layout.fragment_rent, container, false);
        // Inflate the layout for this fragment
        btnRent = v.findViewById(R.id.btn_rent);
        AdresseLocation = v.findViewById(R.id.txtAdresselocation);
        Hours = v.findViewById(R.id.txtHours);

        btnRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userid = getArguments().getInt("user_id");
                int bikeid = getArguments().getInt("bike_id");
                User u = new User();
                u.setId(userid);
                Bike b = new Bike();
                b.setId(bikeid);
                Location loc = new Location(AdresseLocation.getText().toString(),Hours.getText().toString(), bikeid, userid);
                Log.e("LOCATION",loc.toString());

            }
        });

        return v;
    }



}