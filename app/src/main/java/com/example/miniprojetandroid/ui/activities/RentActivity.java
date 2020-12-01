package com.example.miniprojetandroid.ui.activities;
import com.example.miniprojetandroid.ui.fragments.FragmentOne;
import com.example.miniprojetandroid.ui.fragments.FragmentThree;
import com.example.miniprojetandroid.ui.fragments.FragmentTwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.miniprojetandroid.R;

public class RentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);
    }




    public void showFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentsContainer,fragment)
                .commit();
    }

    public void openFragOne(View view) {
        showFragment(new FragmentOne());
    }

    public void openFragTwo(View view) {

        showFragment(new FragmentTwo());
    }

    public void openFragThree(View view) {
        showFragment(new FragmentThree());
    }

    
}
