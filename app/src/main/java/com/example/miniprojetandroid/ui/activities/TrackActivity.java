package com.example.miniprojetandroid.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.miniprojetandroid.R;
import com.example.miniprojetandroid.ui.fragments.FragmentOne;
import com.example.miniprojetandroid.ui.fragments.FragmentTwo;
import com.example.miniprojetandroid.ui.fragments.RecordFragment;
import com.example.miniprojetandroid.ui.fragments.RecordListFragment;

public class TrackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
    }

    public void showFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentsContainer,fragment)
                .commit();
    }

    public void openRecord(View view)
    {
        showFragment(new RecordFragment());
    }

    public void openRecordList(View view) {

        showFragment(new RecordListFragment());
    }





}
