package com.example.bibliotheque;

import javafx.application.Application;


import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Biblio extends Application {
    private final double largeur = 640;
    private final double longueur= 540;
    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(new Controller(20));
        stage.setTitle("Hello!");
        stage.setHeight(largeur);
        stage.setWidth(longueur);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}