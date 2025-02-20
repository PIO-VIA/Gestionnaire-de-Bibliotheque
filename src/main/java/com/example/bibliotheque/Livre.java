package com.example.bibliotheque;

public class Livre {
    private int Idlivre;
    private String nom;
    private String auteur;
    private int prix;
    private String etat;

    public Livre(int Idlivre, String nom, String auteur, int prix, String etat) {
        this.Idlivre = Idlivre;
        this.nom = nom;
        this.auteur = auteur;
        this.prix = prix;
        this.etat = etat;
    }

    // Getters et Setters

    public int getIdlivre() {
        return Idlivre;
    }

    public String getNom() {
        return nom;
    }

    public String getEtat() {
        return etat;
    }

    public int getPrix() {
        return prix;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setIdlivre(int idlivre) {
        Idlivre = idlivre;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}