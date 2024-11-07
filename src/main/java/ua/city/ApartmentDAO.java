package ua.city;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApartmentDAO {
    // Insert (Create)
    public void insertApartment(int id, int buildingId, int number) {
        String sql = "INSERT INTO квартира (id, building_id, number) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, buildingId);
            pstmt.setInt(3, number);
            pstmt.executeUpdate();
            System.out.println("Apartment inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select all (Read)
    public void getAllApartments() {
        String sql = "SELECT * FROM квартира";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Building ID: " + rs.getInt("building_id") + ", Number: " + rs.getInt("number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateApartment(int id, int newNumber) {
        String sql = "UPDATE квартира SET number = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newNumber);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Apartment updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteApartment(int id) {
        String sql = "DELETE FROM квартира WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Apartment deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
