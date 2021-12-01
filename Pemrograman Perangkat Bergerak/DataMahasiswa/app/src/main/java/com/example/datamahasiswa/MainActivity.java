package com.example.datamahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.List;

public class MainActivity extends ListActivity {
    String dataSiswa[] = null;
    String dS[] = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        // Tambah Siswa
        DatabaseHandler db = new DatabaseHandler(this);
        // Membaca Semua Siswa
        Log.d("Baca Siswa: ", "Membaca Semua Data Siswa..");
        List<Siswa> siswa = db.getSemuaSiswa();
        dataSiswa= new String[siswa.size()];
        dS= new String[siswa.size()];
        int i=0;
        for(Siswa s : siswa) {
            String log = "NIS: "+ s.getNis() + ",Nama: "+
                    s.getNama();
            Log.d("Name: ", log);
            dataSiswa[i] = s.getNis() + " - "+ s.getNama();
            dS[i] = s.getNis();
            i++;
        }

        // check data
        if(i==0)
        {
            Log.d("Tambah Siswa: ", "Menambah Data Siswa..");
            db.addSiswa(new Siswa("001", "Ghiyatsi Miftahur Rahmat"));
            db.addSiswa(new Siswa("002", "Annisa Fitriana"));
            db.addSiswa(new Siswa("003", "Andina Nur Amalia"));
            db.addSiswa(new Siswa("004", "Najwa Aulia Dhofiroh"));
        }
        setListAdapter(new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1, dataSiswa));
        registerForContextMenu(getListView());
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
// TODOAuto-generated method stub
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Action");
        menu.add(0,0,0,"Tambah");
        menu.add(0,1,1,"Hapus");
        menu.add(0,2,2,"Update");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
// TODOAuto-generated method stub
        try{
            switch(item.getItemId()){
                case 0:{
                    Class c = Class.forName("com.example.datamahasiswa.Tambah");
                    Intent i = new Intent(MainActivity.this, c);
                    startActivity(i);break;
                }
                case 1:{
                    DatabaseHandler db = new DatabaseHandler(this);
                    AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    String[] args = {String.valueOf(info.id) };
                    int xpos=Integer.parseInt(args[0]);
                    db.deleteRow(dS[xpos]);
                    Class c = Class.forName("com.example.datamahasiswa.MainActivity");
                    Intent i = new Intent(MainActivity.this, c);
                    startActivity(i);
                    break;
                }
                case 2:{
                    DatabaseHandler db = new DatabaseHandler(this);
                    AdapterView.AdapterContextMenuInfo info =(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    String[] args ={String.valueOf(info.id)};
                    Log.d("args0 : ",args[0]);
                    int xpos=Integer.parseInt(args[0]);
                    db.getSiswa(dS[xpos]);
                    String namax=db.getSiswa(dS[xpos]).getNama();
                    Intent i = new Intent(this, Update.class);
                    Bundle bun = new Bundle();
                    bun.putString("nis", dS[xpos]);
                    bun.putString("nama", namax);
                    i.putExtras(bun);
                    startActivity(i); break;
                }
            }
        }catch(ClassNotFoundException e) {
            // TODOAuto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

}