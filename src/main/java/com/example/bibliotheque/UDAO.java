package com.example.bibliotheque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UDAO {
    //afficher utilisateur
    public  List<Utilisateur> afficherU() {
        List<Utilisateur> livres = new ArrayList<>();
        String query = "SELECT * FROM Utilisateur";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet res = pstmt.executeQuery()) {
            while (res.next()) {
                Utilisateur livre = new Utilisateur(
                        res.getInt("IdUtilisateur"),
                        res.getString("nom"),
                        res.getString("surname"),
                        res.getInt("IbTel"),
                        res.getString("eligibilite")
                );
                livres.add(livre);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'affichage des livres : " + e.getMessage());
        }
        return livres;
    }
    //----ajouter un utilisateur
    public void ajouterU(int IdU, String nom, String prenom, int tel, String etat) {
        String query = "INSERT INTO Utilisateur (IdUtilisateur, nom, surname, IbTel, eligibilite) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, IdU);
            pstmt.setString(2, nom);
            pstmt.setString(3, prenom);
            pstmt.setInt(4, tel);
            pstmt.setString(5, etat);
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Livre ajouté avec succès !");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du livre : " + e.getMessage());
        }
    }
}
