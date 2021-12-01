package com.example.ayamku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class Pembayaran extends AppCompatActivity {
    private EditText kembalian, bayaran, editagihan;
    TextView tagihan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        kembalian = (EditText) findViewById(R.id.kembali);
        bayaran = (EditText) findViewById(R.id.jumlahbayar);
        editagihan = (EditText) findViewById(R.id.transaksi);
        tagihan = findViewById(R.id.transaksi);

        Intent intent = getIntent();
        String angka = intent.getStringExtra("TOTALTAGIHAN");
        tagihan.setText(angka);

        editagihan.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                kembalian.setText(addNumbers());
            }

            public void afterTextChanged(Editable s) {
            }
        });

        bayaran.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                kembalian.setText(addNumbers());

            }

            public void afterTextChanged(Editable s) {
            }
        });
    }

    private String addNumbers() {
        int angka1;
        int angka2, sum;
        String angkahasil;
        if (bayaran.getText().toString() != "" && bayaran.getText().length() > 0) {
            angka1 = Integer.parseInt(bayaran.getText().toString());
        } else {
            angka1 = 0;
        }
        if (editagihan.getText().toString() != "" && editagihan.getText().length() > 0) {
            angka2 = Integer.parseInt(editagihan.getText().toString());
        } else {
            angka2 = 0;
        }
        if (angka1 - angka2 <= 0) {
            sum = 0;
            angkahasil = Integer.toString(sum);
            return angkahasil;

        } else {
            angkahasil = Integer.toString(angka1 - angka2);
            return angkahasil;

        }
    }
}