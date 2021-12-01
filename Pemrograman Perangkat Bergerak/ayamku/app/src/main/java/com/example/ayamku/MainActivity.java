package com.example.ayamku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements homeadapter.OnNoteListener {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager LayoutManager;
    homeadapter adapter;
    ArrayList<home> data;
    public String total2;
    public TextView totalView;
    public TextView price;
    public int total_harga_integer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();
        totalView = (TextView)  findViewById(R.id.total);
        price = (TextView) findViewById(R.id.harga) ;

        total_harga_integer = 0;

        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);

        LayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(LayoutManager);

        data = new ArrayList<>();
        for (int i = 0; i< Menuitem.title.length; i++){
            data.add(new home(
                    Menuitem.title[i],
                    Menuitem.harga[i],
                    Menuitem.image[i]
            ));
        }

        adapter = new homeadapter(data, this, this);
        recyclerView.setAdapter(adapter);

        totalView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                total2 = totalView.getText().toString();
                Intent intent = new Intent(MainActivity.this, Pembayaran.class);
                intent.putExtra("TOTALTAGIHAN", total2);
                startActivity(intent);
            }
        });

    }

    public void onNoteClick(int position) {
        int i = Integer.parseInt(Menuitem.harga[position]);
        total_harga_integer = total_harga_integer+i;
        totalView.setText(""+total_harga_integer);
    }

    // menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.profil){
            startActivity(new Intent(this, profilesetting.class));
        } else if (item.getItemId()==R.id.call){
            Toast.makeText(this, "024-722*", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId()==R.id.sms){
            Toast.makeText(this, "0856154*", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId()==R.id.lokasi){
            Toast.makeText(this, "Maps Lokasi", Toast.LENGTH_SHORT).show();
        }
        return true;
    }



}