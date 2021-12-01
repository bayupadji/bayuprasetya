package com.example.ayamku;

public class home {
    private String title;
    private String harga;
    private int image;

    public home (String title, String harga, int image){
        this.title = title;
        this.harga = harga;
        this.image = image;
    }

    public String getTitle(){

        return title;
    }

    public String getHarga(){

        return harga;
    }

    public int getImage(){

        return image;
    }



}
