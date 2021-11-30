package com.example.datamahasiswa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION= 1;
    // NamaDatabase
    private static final String DATABASE_NAME= "DataBarang";
    // NamaTable
    private static final String TABLE_BARANG= "Barang";
    // NamaKolomTable Siswa
    private static final String KEY_KDBRG= "kdbarang";
    private static final String KEY_NAMA= "nama";
    private static final String KEY_BELI= "hgbeli";
    private static final String KEY_JUAL= "hgjual";
    private static final String KEY_STOK= "jmlstok";

    public DatabaseHandler(Context context) {
    // TODOAuto-generated constructor stub
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // Create Table
    @Override
    public void onCreate(SQLiteDatabase db) {
    // TODOAuto-generated method stub
        String query_table_barang = "CREATE TABLE "+ TABLE_BARANG + "("+KEY_KDBRG + " TEXT PRIMARY KEY, "+ KEY_NAMA + " TEXT NOT NULL, "+ KEY_BELI +" TEXT NOT NULL, "+ KEY_JUAL +" TEXT NOT NULL, "+ KEY_STOK +" TEXT NOT NULL)";
        db.execSQL(query_table_barang);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // TODOAuto-generated method stub
    // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_BARANG);
    // Create tables again
        onCreate(db);
    }


    // add new barang
    public void addBarang(Barang barang) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_KDBRG, barang.getKdbarang());
        values.put(KEY_NAMA, barang.getNama());
        values.put(KEY_BELI, barang.getBeli());
        values.put(KEY_JUAL, barang.getJual());
        values.put(KEY_STOK, barang.getStok());
// Inserting Row
        db.insert(TABLE_BARANG, null, values);
        db.close();
    }

    // read barang
    public Barang getBarang(String kdbarang) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_BARANG, new String[] {KEY_KDBRG, KEY_NAMA}, KEY_KDBRG+ "=?", new String[] {kdbarang}, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Barang barang = new Barang(cursor.getString(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4) );
        return barang;
    }

    //read all siswa
    public List<Barang> getSemuaBarang() {
        List<Barang> barangList = new ArrayList<Barang>();
        String query_select_barang = "SELECT * FROM "+ TABLE_BARANG;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query_select_barang,null);
        if(cursor.moveToFirst()) {
            do{
                Barang barang = new Barang(cursor.getString(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4) );
                barangList.add(barang);
            } while(cursor.moveToNext());
        }
        return barangList;
    }


    //delete data barang
    public void deleteBarang(Barang barang) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BARANG, KEY_KDBRG+ "='"+ barang.getKdbarang()+"'",null);
        db.close();
        System.out.println("Data terhapus "+barang.getKdbarang());
    }


    public void deleteRow(String xkdbarang) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BARANG, KEY_KDBRG+ "='"+ xkdbarang+"'",null);
        db.close();
        System.out.println("Data terhapus "+xkdbarang);
    }

    public void updateMethod(String kdbarang, String nama, int beli, int jual, int stok){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update "+TABLE_BARANG + " set nama='" + nama + "'" + " ,beli=" + beli + " ,jual=" + jual + " ,stok=" + stok +" where kdbarang='" + kdbarang + "'") ;
        db.close();
        System.out.println("Data sudah di update "+kdbarang);
    }

}


