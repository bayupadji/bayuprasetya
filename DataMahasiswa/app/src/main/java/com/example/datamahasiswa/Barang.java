package com.example.datamahasiswa;

public class Barang {
    private String kdbarang;
    private String nama;
    private int beli;
    private int jual;
    private int stok;

    public Barang(String kdbarang, String nama, int beli, int jual, int stok) {
        this.kdbarang= kdbarang;
        this.nama= nama;
        this.beli= beli;
        this.jual= jual;
        this.stok= stok;
    }
    public String getKdbarang() {
        return kdbarang;
    }
    public void setKdbarang(String kdbarang) {
        this.kdbarang= kdbarang;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama= nama;
    }

    public int getBeli() {
        return beli;
    }

    public void setBeli(int beli) {
        this.beli = beli;
    }

    public int getJual() {
        return jual;
    }

    public void setJual(int jual) {
        this.jual = jual;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
