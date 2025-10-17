package com.example.bibliotheque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EDAO {
    public List<Pret> afficherE() {
        List<Pret> livres = new ArrayList<>();
        String query = "SELECT * FROM Emprunt";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet res = pstmt.executeQuery()) {
            while (res.next()) {
                Pret livre = new Pret(
                        res.getInt("IDlivre"),
                        res.getInt("IDU"),
                        res.getString("date")
                );
                livres.add(livre);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'affichage des livres : " + e.getMessage());
        }
        return livres;
    }

    public void ajouterE(int IdEmprunt, int Idlivre,  int IdUtilisateur,String date) {
        String query = "INSERT INTO Emprunt (IdEmprunt, Idlivre, IdUtilisateur, dateE) VALUES (?, ?, ?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, IdEmprunt);
            pstmt.setInt(2, Idlivre);
            pstmt.setInt(3, IdUtilisateur);
            pstmt.setString(4,date);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Livre ajouté avec succès !");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du livre : " + e.getMessage());
        }
    }
}
