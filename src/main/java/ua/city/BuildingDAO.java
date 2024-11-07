package ua.city;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuildingDAO {
    // Insert (Create)
    public void insertBuilding(int id, String address, int streetId) {
        String sql = "INSERT INTO будинок (id, address, street_id) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, address);
            pstmt.setInt(3, streetId);
            pstmt.executeUpdate();
            System.out.println("Building inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select all (Read)
    public void getAllBuildings() {
        String sql = "SELECT * FROM будинок";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Address: " + rs.getString("address") + ", Street ID: " + rs.getInt("street_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateBuilding(int id, String newAddress) {
        String sql = "UPDATE будинок SET address = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newAddress);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Building updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteBuilding(int id) {
        String sql = "DELETE FROM будинок WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Building deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

