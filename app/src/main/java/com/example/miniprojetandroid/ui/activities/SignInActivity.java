package com.example.miniprojetandroid.ui.activities;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.miniprojetandroid.R;
import com.example.miniprojetandroid.models.User;
import com.example.miniprojetandroid.database.AppDatabase;


public class SignInActivity extends AppCompatActivity {

    public static final String FNAME_KEY = "FNAME";
    public static final String LNAME_KEY = "LNAME";
    public static final String EMAIL_KEY = "EMAIL";
    public static final String PWD_KEY = "PASSWORD";
    public static final String PHONE_KEY = "PHONE";
    public static final String CHECKED_KEY = "CHECKED";

        private AppDatabase database ;
        public static final String sharedPrefFile = "com.example.miniprojetandroid.shared";
        private SharedPreferences mPreferences;
        EditText email, password;
        private CheckBox cbRememberMe;
        public static User currentUser;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_in);
            database = AppDatabase.getAppDatabase(this);
            email = (EditText) findViewById(R.id.edSignInEmail);
            password = (findViewById(R.id.edSignInPassword));
            cbRememberMe = findViewById(R.id.cbRememberMe);

            //TODO 1 get SharedPref And set EditText
            mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
            email.setText( mPreferences.getString(EMAIL_KEY,"") );
            password.setText( mPreferences.getString(PWD_KEY,"") );
            cbRememberMe.setChecked( mPreferences.getBoolean(CHECKED_KEY, false) );
        }

        public void goToSignUp(View view) {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        }

        public void SignIn(View view) {

            if(validator()) {
                //TODO 3 Save SharedPref
                if (cbRememberMe.isChecked()){
                    SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                    preferencesEditor.putString(EMAIL_KEY, email.getText().toString());
                    preferencesEditor.putString(PWD_KEY, password.getText().toString());
                    preferencesEditor.putBoolean(CHECKED_KEY, true);
                    preferencesEditor.apply();
                }else {
                    SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                    preferencesEditor.putString(EMAIL_KEY, "");
                    preferencesEditor.putString(PWD_KEY, "");
                    preferencesEditor.putBoolean(CHECKED_KEY, false);
                    preferencesEditor.clear();
                    preferencesEditor.apply();
                }

                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra(FNAME_KEY, currentUser.getName());
                intent.putExtra(LNAME_KEY, currentUser.getLastName());
                intent.putExtra(EMAIL_KEY, currentUser.getEmail());
                intent.putExtra(PHONE_KEY, currentUser.getPhone());
                Log.d("User", String.valueOf(currentUser.toString()));
                startActivity(intent);
                finish();
            }

            }


        public void SignInFB(View view) {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        }


    public boolean validator(){

        if (email.getText().toString().length() == 0
                || password.getText().toString().length() == 0 ){
            Toast.makeText(this, "Email and password must not be empty !", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!email.getText().toString().contains("@")){
            Toast.makeText(this, "Email is not valid !", Toast.LENGTH_SHORT).show();
            return false;
        }
        //TODO 2 Check user existance in database
        currentUser = database.userDao()
                .findByEmailAndPassword(
                        email.getText().toString(),
                        password.getText().toString());

        if (currentUser == null){
            Toast.makeText(this, "Wrong credential !", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }



}
