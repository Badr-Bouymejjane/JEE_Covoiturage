package dao;

import model.Role;
import model.Utilisateur;
import util.DatabaseConnection;
import util.PasswordUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurDao {

    public void creerUtilisateur(Utilisateur user) throws SQLException {
        String hashedPassword = PasswordUtils.hashPassword(user.getMotDePasse());

        String sql = "INSERT INTO utilisateur (Nom, Prenom, Email, MotDePasse, Role) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, user.getNom());
            pstmt.setString(2, user.getPrenom());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, hashedPassword);
            pstmt.setString(5, user.getRole().name());

            pstmt.executeUpdate();
            System.out.println("Utilisateur inséré en BDD : " + user.getEmail());

        } catch (SQLException e) {
            System.err.println("Erreur SQL lors de la création de l'utilisateur.");
            e.printStackTrace();
            throw e;
        }
    }

    public Utilisateur findByEmail(String email) {
        String sql = "SELECT * FROM utilisateur WHERE Email = ?";
        Utilisateur user = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new Utilisateur();
                user.setId(rs.getInt("Id"));
                user.setNom(rs.getString("Nom"));
                user.setPrenom(rs.getString("Prenom"));
                user.setEmail(rs.getString("Email"));
                user.setMotDePasse(rs.getString("MotDePasse"));
                user.setRole(Role.valueOf(rs.getString("Role")));
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL lors de la recherche de l'utilisateur.");
            e.printStackTrace();
        }
        return user;
    }
}