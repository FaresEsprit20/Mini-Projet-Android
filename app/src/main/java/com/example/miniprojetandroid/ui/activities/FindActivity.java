package com.example.miniprojetandroid.ui.activities;
import com.example.miniprojetandroid.ui.fragments.MyMapFragment;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;

import com.example.miniprojetandroid.R;

public class FindActivity extends AppCompatActivity {

    private MyMapFragment myMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        FragmentManager fragmentManager =  this.getSupportFragmentManager();
        this.myMapFragment = (MyMapFragment) fragmentManager.findFragmentById(R.id.fragment_map);

    }


}
