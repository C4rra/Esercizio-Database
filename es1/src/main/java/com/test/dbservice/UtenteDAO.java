package com.test.dbservice;

import com.test.model.Utente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class UtenteDAO {
    
    public void createUtente(Utente utente) {
        String sql = "INSERT INTO utente (nome, email, password, balance) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, utente.getNome());
            pstmt.setString(2, utente.getEmail());
            pstmt.setString(3, utente.getPassword());
            pstmt.setDouble(4, utente.getBalance());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Utente> getAllUtenti() {
        String sql = "SELECT * FROM utente";
        List<Utente> utenti = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Utente utente = new Utente(
                    rs.getInt("utenteId"), 
                    rs.getString("nome"), 
                    rs.getString("email"), 
                    rs.getString("password"), 
                    rs.getDouble("balance"));
                utenti.add(utente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utenti;
    }

    public Utente getUtenteById(int id) {
        String sql = "SELECT * FROM utente WHERE utenteId = ?";
        Utente utente = null;
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                utente = new Utente(
                    rs.getInt("utenteId"), 
                    rs.getString("nome"), 
                    rs.getString("email"), 
                    rs.getString("password"), 
                    rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utente;
    }

    public void updateUtente(Utente utente) {
        String sql = "UPDATE utente SET nome = ?, email = ?, password = ? WHERE utenteId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, utente.getNome());
            pstmt.setString(2, utente.getEmail());
            pstmt.setString(3, utente.getPassword());
            pstmt.setInt(4, utente.getUtenteId());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUtente(int utenteId) {
        String sql = "DELETE FROM utente WHERE utenteId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, utenteId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


     public String printUtente(Utente utente) {
        return "Utente{" +
                " nome='" + utente.getNome() + '\'' +
                ", email='" + utente.getEmail() + '\'' +
                '}';
    }

}
