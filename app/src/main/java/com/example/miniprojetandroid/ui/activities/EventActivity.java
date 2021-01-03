package com.example.miniprojetandroid.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.miniprojetandroid.R;
import com.example.miniprojetandroid.ui.fragments.EventsFragment;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        EventsFragment f = new EventsFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentsContainer,f)
                .commit();
    }





}