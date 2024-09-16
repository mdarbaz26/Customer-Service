package customerservice;

import customerservice.DBConnection;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update_Inquiry {
    public static void updateInquiryStatus() {
        try (Connection conn = DBConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter Inquiry ID: ");
            int inquiryId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter New Status: ");
            String status = scanner.nextLine();

            String sql = "UPDATE Inquiry SET status = ? WHERE inquiry_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, status);
                pstmt.setInt(2, inquiryId);
                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Inquiry status updated successfully.");
                } else {
                    System.out.println("Inquiry not found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error updating inquiry status: " + e.getMessage());
        }
    }
}