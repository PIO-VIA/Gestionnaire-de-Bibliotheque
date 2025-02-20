package com.example.bibliotheque;

public class Pret {
    private  int IDlivre;
    private int IDU;
    private  String date;
    public  Pret(int IDlivre, int IDU, String date){
        this.date=date;
        this.IDlivre=IDlivre;
        this.IDU=IDU;
    }

    public int getIDlivre() {
        return IDlivre;
    }

    public int getIDU() {
        return IDU;
    }

    public String getDate() {
        return date;
    }

    public void setIDlivre(int IDlivre) {
        this.IDlivre = IDlivre;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setIDU(int IDU) {
        this.IDU = IDU;
    }
}
