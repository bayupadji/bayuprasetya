package com.example.datamahasiswa;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.List;

public class MainActivity extends ListActivity {
    String dataBarang[] = null;
    String dS[] = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        // Tambah Siswa
        DatabaseHandler db = new DatabaseHandler(this);
        // Membaca Semua Siswa
        Log.d("Baca Siswa: ", "Membaca Semua Data Siswa..");
        List<Barang> barang = db.getSemuaBarang();
        dataBarang= new String[barang.size()];
        dS= new String[barang.size()];
        int i=0;
        for(Barang s : barang) {
            /*String log = "Kode Barang: "+ s.getKdbarang() + ",Nama: "+ s.getNama() + ",Harga Beli: "+ s.getJual() + ",Harga Jual: "+ s.getJual() + ",Stok: "+ s.getStok() ;
            Log.d("Name: ", log);*/
            dataBarang[i] = s.getKdbarang() + " - "+ s.getNama() + " - "+ s.getBeli() + " - "+ s.getJual() + " - "+ s.getStok();
            dS[i] = s.getKdbarang();
            i++;
        }

        // check data
        if(i==0)
        {
            Log.d("Tambah Barang: ", "Menambah Data Barang..");
            db.addBarang(new Barang("001", "Minyak goreng", 15000, 18000, 200));
            db.addBarang(new Barang("002", "Meja", 200000, 300000, 200));
            db.addBarang(new Barang("003", "Kursi", 150000, 200000, 200));
            db.addBarang(new Barang("004", "Mouse", 300000, 400000, 200));
        }
        setListAdapter(new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1, dataBarang));
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
                    db.getBarang(dS[xpos]);
                    String namax=db.getBarang(dS[xpos]).getNama();
                    Intent i = new Intent(this, Update.class);
                    Bundle bun = new Bundle();
                    bun.putString("kdbarang", dS[xpos]);
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