package com.example.ayamku;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private String mSharedPrefFile = "account";
    EditText username, password;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }

    public void login(View view){
        mPreferences = getSharedPreferences(mSharedPrefFile, Activity.MODE_PRIVATE);
        if ((username.getText().toString().equals(mPreferences.getString("username", null))) &&(password.getText().toString().equals(mPreferences.getString("password", null))))
        {
            Preferences.setLoggedInUser(getBaseContext(),Preferences.getRegisteredUser(getBaseContext()));
            Preferences.setLoggedInStatus(getBaseContext(),true);
            Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();

            intent = new Intent(Login.this,MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_SHORT).show();
        }
    }

    public void registrasi(View view){
        Intent i = new Intent(this, Registrasi.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}