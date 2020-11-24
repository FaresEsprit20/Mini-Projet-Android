package com.example.miniprojetandroid.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miniprojetandroid.R;
import com.example.miniprojetandroid.database.AppDatabase;
import com.example.miniprojetandroid.models.User;

public class SignUpActivity extends AppCompatActivity {

    private EditText edSignUpFirstName, edSignUpLastName, edSignUpEmail, edSignUpPassword, edSignUpPhoneNumber;
    private AppDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edSignUpFirstName = findViewById(R.id.edSignUpFirstName);
        edSignUpLastName = findViewById(R.id.edSignUpLastName);
        edSignUpEmail = findViewById(R.id.edSignUpEmail);
        edSignUpPassword = findViewById(R.id.edSignUpPassword);
        edSignUpPhoneNumber = findViewById(R.id.edSignUpPhoneNumber);
        database = AppDatabase.getAppDatabase(this);


    }

    public void doSignUp(View view) {

        if (validator()) {
            User u = new User();
            u.setName(edSignUpFirstName.getText().toString());
            u.setLastName(edSignUpLastName.getText().toString());
            u.setEmail(edSignUpEmail.getText().toString());
            u.setPassword(edSignUpPassword.getText().toString());
            u.setPhone(edSignUpPhoneNumber.getText().toString());
            database.userDao().insertOne(u);
            Toast.makeText(this, "Sign Up Successful !", Toast.LENGTH_SHORT).show();
            finish();
        }
    }


    public boolean validator() {

        if (edSignUpFirstName.getText().toString().length() == 0
                || edSignUpLastName.getText().toString().length() == 0
                || edSignUpEmail.getText().toString().length() == 0
                || edSignUpPassword.getText().toString().length() == 0
                || edSignUpPhoneNumber.getText().toString().length() == 0 ) {
            Toast.makeText(this, "Data must not be empty !", Toast.LENGTH_SHORT).show();
            return false;
        }

        if ((!edSignUpEmail.getText().toString().contains("@")) && (edSignUpEmail.getText().toString().length() <5   )) {
            Toast.makeText(this, "Email is not valid !", Toast.LENGTH_SHORT).show();
            return false;
        }

        //TODO 2 Check user existance in database

        User tmpUser = AppDatabase.getAppDatabase(getApplicationContext()).userDao().findByEmail(edSignUpEmail.getText().toString());
         Log.d("User", String.valueOf(tmpUser.toString()));


        if (tmpUser != null){
            Toast.makeText(this, "User exist in database !", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }
}
