package com.example.bibliotheque;

import javafx.beans.property.SimpleStringProperty;

public class Utilisateur {
    private int IdUtilisateur;
    private  String name;
    private  String surname;
    private String eligibilite;
    private int TEL;


    public Utilisateur(int IdUtilisateur, String name,String surname,int TEL, String eligibilite){
        this.name=name;
        this.surname =surname;
        this.eligibilite=eligibilite;
        this.TEL=TEL;
        this.IdUtilisateur=IdUtilisateur;
    }

    public int getIdUtilisateur() {
        return IdUtilisateur;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEligibilite() {
        return eligibilite;
    }

    public int getTEL() {
        return TEL;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        IdUtilisateur = idUtilisateur;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEligibilite(String eligibilite) {
        this.eligibilite = eligibilite;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTEL(int TEL) {
        this.TEL = TEL;
    }
}
