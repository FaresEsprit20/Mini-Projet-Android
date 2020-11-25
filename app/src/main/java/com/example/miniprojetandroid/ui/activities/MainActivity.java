package com.example.miniprojetandroid.ui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.miniprojetandroid.R;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 10;
    public static final String TAG_NUMBER = "NUMBER";
    Button LogoutClient;
    Button FindClient, LouerClient, TrackClient, Contact;
    private SharedPreferences sp;

    //, edSignUpFirstName, edSignUpLastName, edSignUpEmail, edSignUpPassword, edSignUpPhoneNumber;
    private TextView txtFirstName, txtLastName,txtEmail,txtPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogoutClient = findViewById(R.id.btnlogoutClient);
        FindClient = findViewById(R.id.btnFindClient);
        TrackClient = findViewById(R.id.btnTrackClient);
        LouerClient = findViewById(R.id.btnLouerClient);
        Contact = findViewById(R.id.btnContactClient);
        txtFirstName = findViewById(R.id.txtMainFirstName);
        txtLastName = findViewById(R.id.txtMainLastName);
        txtEmail = findViewById(R.id.txtMainEmail);
        txtPhoneNumber = findViewById(R.id.txtMainPhoneNumber);
        checkAndFillData(getIntent());

        sp = getSharedPreferences("com.example.miniprojetandroid.shared", MODE_PRIVATE);






        FindClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFind();
            }
        });

        TrackClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTrack();
            }
        });

        LouerClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLouer();
            }
        });

        Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onContact();
            }
        });

        LogoutClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogout();
            }
        });
    }


    public void onFind() {
        Intent intent = new Intent(this, FindActivity.class);
        startActivity(intent);
    }

    public void onLouer() {
        Intent intent = new Intent(this, RentActivity.class);
        startActivity(intent);
    }

    public void goToUpdateProfile(View view) {
        Intent intent = new Intent(this, UpdateProfile.class);
        intent.putExtra(SignInActivity.FNAME_KEY, txtFirstName.getText().toString());
        intent.putExtra(SignInActivity.LNAME_KEY, txtLastName.getText().toString());
        intent.putExtra(SignInActivity.EMAIL_KEY, txtEmail.getText().toString());
        intent.putExtra(SignInActivity.PHONE_KEY, txtPhoneNumber.getText().toString());
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void onTrack() {
        Intent intent = new Intent(this, TrackActivity.class);
        startActivity(intent);
    }

    public void onContact() {
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }

    public void onLogout() {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove("LOGIN");
        editor.clear();
        editor.apply();
        finish();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE  && resultCode == RESULT_OK){
            checkAndFillData(data);
        }
    }


    public void checkAndFillData(Intent intent){

        if( intent.hasExtra(SignInActivity.FNAME_KEY) ){
            txtFirstName.setText( intent.getStringExtra(SignInActivity.FNAME_KEY));
        }
        if( intent.hasExtra(SignInActivity.LNAME_KEY) ){
            txtLastName.setText( intent.getStringExtra(SignInActivity.LNAME_KEY));
        }
        if( intent.hasExtra(SignInActivity.EMAIL_KEY) ){
            txtEmail.setText( intent.getStringExtra(SignInActivity.EMAIL_KEY));
        }
        if( intent.hasExtra(SignInActivity.EMAIL_KEY) ){
            txtPhoneNumber.setText( intent.getStringExtra(SignInActivity.PHONE_KEY));
        }

    }


}