package com.example.bibliotheque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivreDAO {
    public void ajouterLivre(int Idlivre, String nom, String auteur, int prix, String etat) {
        String query = "INSERT INTO Livre (Idlivre, nom, auteur, prix, etat) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, Idlivre);
            pstmt.setString(2, nom);
            pstmt.setString(3, auteur);
            pstmt.setInt(4, prix);
            pstmt.setString(5, etat);
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Livre ajouté avec succès !");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du livre : " + e.getMessage());
        }
    }

    public List<Livre> afficherLivres() {
        List<Livre> livres = new ArrayList<>();
        String query = "SELECT * FROM Livre";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet res = pstmt.executeQuery()) {
            while (res.next()) {
                Livre livre = new Livre(
                        res.getInt("Idlivre"),
                        res.getString("nom"),
                        res.getString("auteur"),
                        res.getInt("prix"),
                        res.getString("etat")
                );
                livres.add(livre);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'affichage des livres : " + e.getMessage());
        }
        return livres;
    }

    // Ajoutez d'autres méthodes pour supprimer, mettre à jour, etc.
}