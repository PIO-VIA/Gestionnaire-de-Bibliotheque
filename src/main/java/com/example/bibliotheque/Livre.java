package com.example.bibliotheque;

import javafx.beans.property.SimpleStringProperty;

public class Livre  {
    private final SimpleStringProperty name ;
    private final SimpleStringProperty etat;
    private final SimpleStringProperty auteur;
    private final SimpleStringProperty prix;

    public Livre(String name, String auteur, String prix, String etat) {
        this.name = new SimpleStringProperty(name);
        this.auteur= new SimpleStringProperty(auteur);
        this.etat = new SimpleStringProperty(etat);
        this.prix = new SimpleStringProperty(prix) ;
    }
    public  String getName(){
        return this.name.get();
    }

    public String getEtat() {
        return this.etat.get();
    }
    public void setName(String name){
        this.name.set(name);
    }
    public void setEtat(String url){
        this.etat.set(url);
    }

    public String getAuteur() {
        return auteur.get();
    }
    public void setAuteur(String auteur){
        this.auteur.set(auteur);
    }

    public String getPrix() {
        return prix.get();
    }
    public void setPrix(String prix){
        this.prix.set(prix);
    }
}

