package com.example.datamahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update extends AppCompatActivity {
    private String xkdbarang,xnama;
    private int xbeli,xjual,xstok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        final DatabaseHandler db = new DatabaseHandler(this);
        final EditText editKdbrg = (EditText)findViewById(R.id.updatekdbrg);
        final EditText editNama = (EditText) findViewById(R.id.updatenama);
        final EditText editBeli = (EditText) findViewById(R.id.updatebeli);
        final EditText editJual = (EditText) findViewById(R.id.updatejual);
        final EditText editStok = (EditText) findViewById(R.id.updatestok);
        Button btnTambah = (Button) findViewById(R.id.btnUpdate);
        Button btnBatal = (Button) findViewById(R.id.btnCancel);

        // ambil data barang
        Bundle bun = this.getIntent().getExtras();
        xkdbarang = bun.getString("kdbarang");
        xnama = bun.getString("nama");
        xbeli = bun.getInt("hgbeli");
        xjual = bun.getInt("hgjual");
        xstok = bun.getInt("stok");

        //masukkan data barang
        editNama.setText(xnama);
        editKdbrg.setText(xkdbarang);
        editBeli.setText(xbeli);
        editJual.setText(xjual);
        editStok.setText(xstok);

        btnTambah.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String kdbarang = editKdbrg.getText().toString();
                String nama = editNama.getText().toString();
                int beli = Integer.valueOf(editBeli.getText().toString());
                int jual = Integer.valueOf(editJual.getText().toString());
                int stok = Integer.valueOf(editStok.getText().toString());

                db.updateMethod(kdbarang,nama,beli,jual,stok);
                editKdbrg.setText("");
                editNama.setText("");
                editBeli.setText("");
                editJual.setText("");
                editStok.setText("");

                try{
                    Class c= Class.forName("com.example.datamahasiswa.MainActivity");
                    Intent i = new Intent(Update.this, c);
                    startActivity(i);
                } catch(ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        btnBatal.setOnClickListener(new View.OnClickListener()
        {public void onClick(View v) {
            try {
                Class c = Class.forName("com.example.datamahasiswa.MainActivity");
                Intent i=new Intent(Update.this,c);
                startActivity(i);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        });
    }
}