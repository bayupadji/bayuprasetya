package com.example.datamahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tambah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        final DatabaseHandler db = new DatabaseHandler(this);
        final EditText editKdbrg = (EditText)findViewById(R.id.inputkdbrg);
        final EditText editNama = (EditText) findViewById(R.id.inputnama);
        final EditText editBeli = (EditText) findViewById(R.id.inputbeli);
        final EditText editJual = (EditText) findViewById(R.id.inputjual);
        final EditText editStok = (EditText) findViewById(R.id.inputstok);
        Button btnTambah = (Button) findViewById(R.id.btnTambah);
        Button btnBatal = (Button) findViewById(R.id.btnCancel);
        btnTambah.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String kdbarang = editKdbrg.getText().toString();
                String nama = editNama.getText().toString();
                int beli = Integer.valueOf(editBeli.getText().toString());
                int jual = Integer.valueOf(editJual.getText().toString());
                int stok = Integer.valueOf(editStok.getText().toString());
                db.addBarang(new Barang(kdbarang,nama,beli,jual,stok));
                editKdbrg.setText("");
                editNama.setText("");
                editBeli.setText("");
                editJual.setText("");
                editStok.setText("");
                try{
                    Class c = Class.forName("com.example.datamahasiswa.MainActivity");
                    Intent i = new Intent(Tambah.this, c);
                    startActivity(i);
                } catch(ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        btnBatal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    Class c = Class.forName("com.example.datamahasiswa.MainActivity");
                    Intent i=new Intent(Tambah.this,c);
                    startActivity(i);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
