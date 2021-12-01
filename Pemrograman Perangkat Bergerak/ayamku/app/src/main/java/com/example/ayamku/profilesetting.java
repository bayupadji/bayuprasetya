package com.example.ayamku;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class profilesetting extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private String mSharedPrefFile = "account";
    EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilesetting);

        user = findViewById(R.id.edituser);
        pass = findViewById(R.id.editpass);
    }

    public void update(View view){
        mPreferences = getSharedPreferences(mSharedPrefFile, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString("username", user.getText().toString());
        editor.putString("password", pass.getText().toString());
        editor.commit();
        Toast.makeText(getApplicationContext(), "Berhasil Simpan", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void btnCancel(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}