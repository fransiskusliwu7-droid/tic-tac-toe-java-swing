package com.mycompany.finalprojectpemdasjava;
import java.sql.*;
import java.util.ArrayList;

class PlayerService {
    public Player login(String username, String password) {
        String cleanUser = username.trim();
        String cleanPass = password.trim();
        
        String sql = "SELECT * FROM players WHERE username = ? AND password = ?";
        
        System.out.println("DEBUG: Mencoba login ke DB...");
        System.out.println("DEBUG: Username: " + cleanUser);
        System.out.println("DEBUG: Password: " + cleanPass);
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cleanUser);
            stmt.setString(2, cleanPass);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("DEBUG: User ditemukan di database!");
                return new Player(rs.getInt("id"), rs.getString("username"),
                        rs.getInt("wins"), rs.getInt("losses"),
                        rs.getInt("draws"), rs.getInt("score"));
            } else {
                System.out.println("DEBUG: User TIDAK ditemukan (Login gagal)");
            }
        } catch (Exception e) { 
            System.out.println("DEBUG: Terjadi Error Koneksi!");
            e.printStackTrace(); 
        }
        return null;
    }

    public void updateStatistics(Player player, String result) {
        int additionalScore = 0;
        String sql = "";
        if (result.equalsIgnoreCase("WIN")) {
            additionalScore = 10;
            sql = "UPDATE players SET wins = wins + 1, score = score + ? WHERE id = ?";
        } else if (result.equalsIgnoreCase("LOSE")) {
            sql = "UPDATE players SET losses = losses + 1, score = score + ? WHERE id = ?";
        } else if (result.equalsIgnoreCase("DRAW")) {
            additionalScore = 3;
            sql = "UPDATE players SET draws = draws + 1, score = score + ? WHERE id = ?";
        }
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, additionalScore);
            stmt.setInt(2, player.getId());
            stmt.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public ArrayList<Player> getTopFives() {
        ArrayList<Player> list = new ArrayList<>();
        String sql = "SELECT * FROM players ORDER BY score DESC, wins DESC LIMIT 5";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Player(rs.getInt("id"), rs.getString("username"),
                        rs.getInt("wins"), rs.getInt("losses"),
                        rs.getInt("draws"), rs.getInt("score")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}