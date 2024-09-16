package customerservice;

import customerservice.DBConnection;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class View_Inquiry {
    // Method to view inquiry details
    public static void viewInquiryDetails() {
        try (Connection conn = DBConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter Inquiry ID: ");
            int inquiryId = scanner.nextInt();

            String sql = "SELECT * FROM Inquiry WHERE inquiry_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, inquiryId);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Inquiry ID: " + rs.getInt("inquiry_id"));
                        System.out.println("Customer ID: " + rs.getInt("customer_id"));
                        System.out.println("Inquiry Date: " + rs.getDate("inquiry_date"));
                        System.out.println("Description: " + rs.getString("description"));
//                        System.out.println("Status: " + rs.getString("status"));
                    } else {
                        System.out.println("Inquiry not found.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error viewing inquiry: " + e.getMessage());
        }
    }
}