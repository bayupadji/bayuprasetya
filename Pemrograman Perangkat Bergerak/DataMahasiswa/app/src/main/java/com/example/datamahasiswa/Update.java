package com.example.datamahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update extends AppCompatActivity {
    private String xnis,xnama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        final DatabaseHandler db = new DatabaseHandler(this);
        final EditText editNis = (EditText)findViewById(R.id.updatenis);
        final EditText editNama = (EditText) findViewById(R.id.updatenama);
        Button btnTambah = (Button) findViewById(R.id.btnUpdate);
        Button btnBatal = (Button) findViewById(R.id.btnCancel);

        // ambil data siswa
        Bundle bun = this.getIntent().getExtras();
        xnis = bun.getString("nis");
        xnama = bun.getString("nama");

        //masukkan data siswa
        editNama.setText(xnama);
        editNis.setText(xnis);

        btnTambah.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String nis = editNis.getText().toString();
                String nama = editNama.getText().toString();
                //db.addSiswa(new Siswa(nis, nama));
                //db.updateData(nis,nama);
                db.updateMethod(nis,nama);
                editNis.setText("");
                editNama.setText("");
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