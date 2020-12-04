package com.example.miniprojetandroid.ui.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miniprojetandroid.R;
import com.example.miniprojetandroid.models.Bike;
import com.example.miniprojetandroid.models.User;


public class DetailsFragment extends Fragment {

    Button btnRent, btnFav;
    TextView lbmodel,lbtype,lbprice;
    private SharedPreferences sp;

    public static Bike bike;

    public DetailsFragment() {
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
        View v = inflater.inflate(R.layout.fragment_details, container, false);
        btnRent = v.findViewById(R.id.btnRent);
        btnFav = v.findViewById(R.id.btnFav);
        lbmodel = v.findViewById(R.id.model);
        lbtype = v.findViewById(R.id.type);
        lbprice = v.findViewById(R.id.price);

        int id = getArguments().getInt("bike_id");
        String model = getArguments().getString("model");
        String type = getArguments().getString("type");
        String price = getArguments().getString("price");
        int image = getArguments().getInt("image");
         bike = new Bike(id,model,type,price,image);
        Log.e("ddddddddd",bike.toString());

        lbmodel.setText("Model :       "+bike.getModel());
        lbtype.setText("Bike :         "+bike.getType());
        lbprice.setText("Price per hour :         "+bike.getPrice());

        btnRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sp = getActivity().getSharedPreferences("com.example.miniprojetandroid.shared", Context.MODE_PRIVATE);
                User u = new User();
                u.setId(Integer.parseInt(sp.getString("ID","")));
                Log.e("User " , u.toString());
                Bundle bundle = new Bundle();
                bundle.putInt("user_id",u.getId());
                bundle.putInt("bike_id",bike.getId());
                bundle.putString("model", bike.getModel());
                bundle.putString("type", bike.getType());
                bundle.putString("price", bike.getPrice());
                bundle.putInt("image", bike.getImage());
                RentFragment f = new RentFragment();
                f.setArguments(bundle);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentsContainer, f )
                        .commit();
            }
        });


        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Added to Favourites!",Toast.LENGTH_SHORT).show();
                FragmentThree f = new FragmentThree();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentsContainer, f )
                        .commit();
            }
        });

        return v;
    }


}