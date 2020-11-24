package com.example.miniprojetandroid.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miniprojetandroid.R;

public class MainActivityAdmin extends AppCompatActivity {

    Button btnAddBike, btnLocations, btnLogoutAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
        btnAddBike = findViewById(R.id.btnAddBike);
        btnLocations = findViewById(R.id.btnLocations);
        btnLogoutAdmin = findViewById(R.id.btnlogoutAdmin);


        btnAddBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddBike();
            }
        });

        btnLocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGoToLocations();
            }
        });


        btnLogoutAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogoutAdmin();
            }
        });


    }






    public void onAddBike() {
        Intent intent = new Intent(this,   AddBike.class);
        startActivity(intent);

    }

    public void onGoToLocations() {
        Intent intent = new Intent(this,  LocationsActivity.class);
        startActivity(intent);

    }

    public void onLogoutAdmin() {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }





}