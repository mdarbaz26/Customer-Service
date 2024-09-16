package consumerElectronicsStoreManagementSystem;

import java.sql.*;

public class OrderManager {

    // Method to place a new order
    public void placeOrder(int customerId, double totalAmount, String status) {
        String query = "INSERT INTO Orders (customer_id, order_date, total_amount, status) VALUES (?, CURDATE(), ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            stmt.setDouble(2, totalAmount);
            stmt.setString(3, status);
            stmt.executeUpdate();
            System.out.println("Order placed successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to view order by ID
    public void viewOrder(int orderId) {
        String query = "SELECT * FROM Orders WHERE order_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Order ID: " + rs.getInt("order_id"));
                System.out.println("Customer ID: " + rs.getInt("customer_id"));
                System.out.println("Order Date: " + rs.getDate("order_date"));
                System.out.println("Total Amount: $" + rs.getDouble("total_amount"));
                System.out.println("Status: " + rs.getString("status"));
            } else {
                System.out.println("Order not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update the status of an order
    public void updateOrder(int orderId, String newStatus) {
        String query = "UPDATE Orders SET status = ? WHERE order_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newStatus);
            stmt.setInt(2, orderId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Order updated successfully!");
            } else {
                System.out.println("Order with ID " + orderId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to cancel an order
    public void cancelOrder(int orderId) {
        String query = "UPDATE Orders SET status = 'cancelled' WHERE order_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, orderId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Order cancelled successfully!");
            } else {
                System.out.println("Order with ID " + orderId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
