package com.br.model.entity;



public class VinylRecord extends Products {
    private String bandsName;
    private String musicalStyle;

   

    public String getBandsName() {
        return bandsName;
    }

    public void setBandsName(String bandsName) {
            if(!bandsName.isEmpty()) this.bandsName = bandsName;
            else throw new IllegalArgumentException("Band's name must not be empty");
    }

    public String getMusicalStyle() {
        return musicalStyle;
    }

    public void setMusicalStyle(String musicalStyle) {
            if(!musicalStyle.isEmpty()) this.musicalStyle = musicalStyle;
            else throw new IllegalArgumentException(" Musical style must not be empty");
    }

   

}