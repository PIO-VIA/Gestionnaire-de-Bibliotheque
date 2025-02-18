package com.example.bibliotheque;

import javafx.beans.property.SimpleStringProperty;

public class Utilisateur {
    private final SimpleStringProperty  name;
    private final SimpleStringProperty surname;
    private final SimpleStringProperty eligibilite;


    public Utilisateur(String name,String surname,String eligibilite){
        this.name=new SimpleStringProperty(name);
        this.surname =new SimpleStringProperty(surname);
        this.eligibilite= new SimpleStringProperty(eligibilite);
    }

    public String getSurname() {
        return this.surname.get();
    }


    public String getName() {
        return this.name.get();
    }

    public String getEligibilite() {
        return this.eligibilite.get();
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setPrix(String eligibilite) {
        this.eligibilite.set(eligibilite);
    }
}
