package com.example.bibliotheque;

public class Utilisateur {
    private String name;
    private String auteurs;
    private String prix;
    private String etat;

    public Utilisateur(String name,String auteurs,String prix, String etat){
        this.name=name;
        this.auteurs=auteurs;
        this.prix=prix;
        this.etat=etat;
    }

    public String getAuteurs() {
        return auteurs;
    }

    public String getEtat() {
        return etat;
    }

    public String getName() {
        return name;
    }

    public String getPrix() {
        return prix;
    }

    public void setAuteurs(String auteurs) {
        this.auteurs = auteurs;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
}
