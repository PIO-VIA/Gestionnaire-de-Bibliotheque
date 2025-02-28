package com.example.bibliotheque;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controller  extends BorderPane {


    public Controller(){
        //---Dashboard
        VBox Dashboard =new VBox(10);
        Button accueil =new Button("Accueil");
        Button utilisateur =new Button("Utilisateur");
        Button Finance= new Button("Emprunts");
        Button Stat = new Button("Statistique");
        Button setting= new Button("Parametres");
        Dashboard.getChildren().addAll(accueil,utilisateur,Finance,Stat, setting);
        this.setLeft(Dashboard);
        //----tableau qui  affiche les livres
        TableColumn NOMS =new TableColumn("NOM");
        NOMS.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn AUTEURS =new TableColumn("AUTEURS");
        AUTEURS.setCellValueFactory(new PropertyValueFactory("auteur"));
        TableColumn PRIX = new TableColumn ("PRIX");
        PRIX.setCellValueFactory(new PropertyValueFactory("prix"));
        TableColumn ETATS =new TableColumn("ETATS");
        ETATS.setCellValueFactory(new PropertyValueFactory("etat"));
        ObservableList<Livre> items= FXCollections.observableArrayList
                (
                        new Livre("six pretendantes  ", "Jean Claude", "2500 ","libre")

                );
        TableView tableau= new TableView<>(items);
        tableau.getColumns().addAll(NOMS,AUTEURS, PRIX, ETATS);
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
        TableColumn NOMS =new TableColumn("NOM");
        NOMS.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn SURNAME =new TableColumn("SURNAME");
        SURNAME.setCellValueFactory(new PropertyValueFactory("surname"));
        TableColumn VRAI = new TableColumn ("eligibilite");
        VRAI.setCellValueFactory(new PropertyValueFactory("eligibilite"));

        ObservableList<Utilisateur> items= FXCollections.observableArrayList
                (
                        new Utilisateur("six pretendantes  ", "Jean Claude", "2500 ")
                );
        TableView table= new TableView<>(items);
        table.getColumns().addAll(NOMS,SURNAME, VRAI);
        this.setCenter(table);
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
}


