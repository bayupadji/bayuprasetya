package com.example.datamahasiswa;

public class Siswa {
    private String nis;
    private String nama;
    public Siswa() {
    }
    public Siswa(String nis, String nama) {
        this.nis= nis;
        this.nama= nama;
    }
    public String getNis() {
        return nis;
    }
    public void setNis(String nis) {
        this.nis= nis;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama= nama;
    }
}

