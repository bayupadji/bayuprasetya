package com.example.ayamku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailProduk extends AppCompatActivity {

    TextView textDefault;
    TextView descDefault;
    ImageView imageDefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produk);

        textDefault = findViewById(R.id.titlename);
        descDefault = findViewById(R.id.deskripsi);
        imageDefault = findViewById(R.id.gambardetail);

        Intent i = getIntent();
        int logoAplikasi = i.getIntExtra("GAMBAR_DEFAULT", 0);
        String nAplikasi = i.getStringExtra("TEKS_DEFAULT");
        String dAplikasi = i.getStringExtra("DESC_DEFAULT");

        imageDefault.setImageResource(logoAplikasi);
        textDefault.setText(nAplikasi);
        descDefault.setText(dAplikasi);

    }
}