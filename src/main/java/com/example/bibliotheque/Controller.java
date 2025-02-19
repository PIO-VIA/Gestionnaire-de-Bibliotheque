package com.example.bibliotheque;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.sql.*;

public class Controller  extends BorderPane {
    private LivreDAO livreDAO = new LivreDAO();
    private UDAO U =new UDAO();
    public Controller(){
        //--- connection a la bd

        //---Dashboard
        VBox Dashboard =new VBox(10);
        Button accueil =new Button("Accueil");
        Button utilisateur =new Button("Utilisateur");
        Button Finance= new Button("Emprunts");
        Button Stat = new Button("Statistique");
        Button setting= new Button("Parametres");
        Dashboard.getChildren().addAll(accueil,utilisateur,Finance,Stat, setting);
        this.setLeft(Dashboard);
        //----tableau qui affiche les livres
        TableColumn<Livre,Integer> Idlivre =new TableColumn<>("IdLivre");
        Idlivre.setCellValueFactory(new PropertyValueFactory<>("Idlivre"));
        TableColumn<Livre, String> NOMS = new TableColumn<>("NOM");
        NOMS.setCellValueFactory(new PropertyValueFactory<>("nom"));
        TableColumn<Livre, String> AUTEURS = new TableColumn<>("AUTEURS");
        AUTEURS.setCellValueFactory(new PropertyValueFactory<>("auteur"));
        TableColumn<Livre, Integer> PRIX = new TableColumn<>("PRIX");
        PRIX.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TableColumn<Livre, String> ETATS = new TableColumn<>("ETATS");
        ETATS.setCellValueFactory(new PropertyValueFactory<>("etat"));

        ObservableList<Livre> items = FXCollections.observableArrayList(livreDAO.afficherLivres());
        TableView<Livre> tableau = new TableView<>(items);
        tableau.getColumns().addAll(Idlivre,NOMS, AUTEURS, PRIX, ETATS);
        this.setCenter(tableau);

        //--barre de tache
        VBox tasks =new VBox(10);
        Button ajouter =new Button("ajouter");
        Button supprimer = new Button("supprimer");
        tasks.getChildren().addAll(ajouter,supprimer);
        this.setRight(tasks);
        //---evenement sur les boutons
        utilisateur.setOnAction(event -> utilisateur());
        Finance.setOnAction(event -> Emprunt());


    }

    private void utilisateur(){
        TableColumn<Utilisateur,Integer> Idlivre =new TableColumn<>("IdUtilisateur");
        Idlivre.setCellValueFactory(new PropertyValueFactory<>("IdUtilisateur"));
        TableColumn<Utilisateur, String> NOMS = new TableColumn<>("NOM");
        NOMS.setCellValueFactory(new PropertyValueFactory<>("nom"));
        TableColumn<Utilisateur, String> SURNAME = new TableColumn<>("AUTEURS");
        SURNAME.setCellValueFactory(new PropertyValueFactory<>("surname"));
        TableColumn<Utilisateur, Integer> IB= new TableColumn<>("NUMERO ");
        IB.setCellValueFactory(new PropertyValueFactory<>("IbTel"));
        TableColumn<Utilisateur, String> ETATS = new TableColumn<>("eligibilite");
        ETATS.setCellValueFactory(new PropertyValueFactory<>("eligibilite"));

        ObservableList<Utilisateur> items = FXCollections.observableArrayList(U.afficherU());
        TableView<Utilisateur> tableau = new TableView<>(items);
        tableau.getColumns().addAll(Idlivre,NOMS, SURNAME, IB, ETATS);
        this.setCenter(tableau);
        VBox outils =new VBox(10);
        Button add = new Button("nouveau");
        Button delete =new Button("supprimer");
        outils.getChildren().addAll(add, delete);
        this.setRight(outils);
    }

    private void Emprunt(){
        VBox outils= new VBox(10);
        Button add = new Button("enregistrer");
        outils.getChildren().addAll(add);
        this.setRight(outils);
    }

    //----afficher les livre

    //---- ajouter un livre



}


