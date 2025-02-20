package com.example.bibliotheque;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.sql.*;
import java.util.Random;

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
        ajouter.setOnAction(event -> AddL(tableau));
        supprimer.setOnAction(event -> DeleteL(tableau));
        accueil.setOnAction(event -> Home(tableau));


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
        //--- evenement des boutons
        add.setOnAction(event -> addU(tableau));
        delete.setOnAction(event -> supprimerU(tableau));
        this.setBottom(null);
    }

    private void Emprunt(){
        VBox outils= new VBox(10);
        Button add = new Button("enregistrer");
        outils.getChildren().addAll(add);
        this.setRight(outils);
    }
    private void addU(TableView tableau){
        UDAO U = new UDAO();
        HBox bas =new HBox(5);
        Label nom = new Label("nom");
        TextField Enom= new TextField();
        Label prenom = new Label("Prenom");
        TextField Eprenom =new TextField();
        Label IB =new Label("numero");
        TextField EIB =new TextField();
        Button fin = new Button("AJouter");
        bas.getChildren().addAll(nom, Enom,prenom,Eprenom,IB,EIB,fin);
        fin.setOnAction(event -> {
            String Pnom =Enom.getText();
            String Psurname =Eprenom.getText();
            int Pib = Integer.parseInt(EIB.getText());
            Random R =new Random();
            int ID=R.nextInt(100000);
            U.ajouterU(ID,Pnom,Psurname,Pib,"Vrai");
            tableau.setItems(FXCollections.observableArrayList(U.afficherU()));
            this.setBottom(null);

        });

        this.setBottom(bas);
    }
    private void supprimerU(TableView tableau){
        UDAO U = new UDAO();
        HBox B =new HBox(5);
        Label entry =new Label("ID du l'utilisateur");
        TextField T = new TextField();
        Button D = new Button("Supprimer");
        B.getChildren().addAll(entry, T, D);
        this.setBottom(B);
        D.setOnAction(event -> {
            int R =Integer.parseInt(T.getText());
            U.deleteU(R);
            tableau.setItems(FXCollections.observableArrayList(U.afficherU()));
            this.setBottom(null);
        });
    }
    private void AddL(TableView tableau){
        LivreDAO LivreDAO =new LivreDAO();
        HBox A =new HBox(5);
        Label nom = new Label("Nom");
        TextField Enom= new TextField();
        Label prenom = new Label("Auteur");
        TextField Eprenom =new TextField();
        Label IB =new Label("Prix");
        TextField EIB =new TextField();
        Button fin = new Button("AJouter");
        A.getChildren().addAll(nom,Enom,prenom,Eprenom,IB,EIB,fin);
        this.setBottom(A);
        fin.setOnAction(event -> {
            String Pnom =Enom.getText();
            String Psurname =Eprenom.getText();
            int Pib = Integer.parseInt(EIB.getText());
            Random R =new Random();
            int ID=R.nextInt(100000);
            LivreDAO.ajouterLivre(ID,Pnom,Psurname,Pib,"Vrai");
            tableau.setItems(FXCollections.observableArrayList(LivreDAO.afficherLivres()));
            this.setBottom(null);
        });

    }

    private void DeleteL(TableView tableau){
        LivreDAO U = new LivreDAO();
        HBox B =new HBox(5);
        Label entry =new Label("ID du LIvre");
        TextField T = new TextField();
        Button D = new Button("Supprimer");
        B.getChildren().addAll(entry, T, D);
        this.setBottom(B);
        D.setOnAction(event -> {
            int R =Integer.parseInt(T.getText());
            U.deletelivre(R);
            tableau.setItems(FXCollections.observableArrayList(U.afficherLivres()));
            this.setBottom(null);
        });

    }

    private void Home(TableView tableau){
        LivreDAO U =new LivreDAO();
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

        tableau.setItems(FXCollections.observableArrayList(U.afficherLivres()));
        this.setCenter(tableau);
        //--barre de tache
        VBox tasks =new VBox(10);
        Button ajouter =new Button("ajouter");
        Button supprimer = new Button("supprimer");
        tasks.getChildren().addAll(ajouter,supprimer);
        this.setRight(tasks);
        this.setBottom(null);
        //---evenement sur les boutons
        ajouter.setOnAction(event -> AddL(tableau));
        supprimer.setOnAction(event -> DeleteL(tableau));



    }





}


