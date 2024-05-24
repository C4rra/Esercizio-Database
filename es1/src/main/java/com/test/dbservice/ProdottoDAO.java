package com.test.dbservice;

import com.test.model.Prodotto;
// import com.test.model.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProdottoDAO {
    
    public void createProdotto(Prodotto prodotto) {
        String sql = "INSERT INTO Prodotto ( name, description, price, stock, utenteId) VALUES ( ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, prodotto.getName());
            pstmt.setString(2, prodotto.getDescription());
            pstmt.setDouble(3, prodotto.getPrice());
            pstmt.setInt(4, prodotto.getStock());
            pstmt.setInt(5, prodotto.getUtenteId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Prodotto getProdottoById(int id) {
        String sql = "SELECT * FROM prodotto WHERE prodottoId = ?";
        Prodotto prodotto = null;
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                prodotto = new Prodotto(rs.getInt("prodottoId"), 
                rs.getString("description"), 
                rs.getString("name"), 
                rs.getDouble("price"), 
                rs.getInt("stock"),
                rs.getInt("utenteId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prodotto;
    }

    public void updateProdotto(Prodotto prodotto) {
        String sql = "UPDATE prodotto SET name = ?, description = ?, price = ?, stock = ?   WHERE prodottoId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, prodotto.getName());
            pstmt.setString(2, prodotto.getDescription());
            pstmt.setDouble(3, prodotto.getPrice());
            pstmt.setInt(4, prodotto.getStock());
            pstmt.setInt(5, prodotto.getProdottoId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProdotto(int id) {
        String sql = "DELETE FROM prodotto WHERE prodottoId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Prodotto> getAllProdotti() {
        String sql = "SELECT * FROM prodotto";
        List<Prodotto> prodotti = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Prodotto prodotto = new Prodotto(rs.getInt("prodottoId"), 
                rs.getString("description"), 
                rs.getString("name"), 
                rs.getDouble("price"), 
                rs.getInt("stock"),
                rs.getInt("utenteId"));
                prodotti.add(prodotto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prodotti;
    }
}
