package customerservice;

import customerservice.DBConnection;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete_Inquiry {
    public static void deleteInquiry() {
        try (Connection conn = DBConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter Inquiry ID: ");
            int inquiryId = scanner.nextInt();

            String sql = "DELETE FROM Inquiry WHERE inquiry_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, inquiryId);
                int rowsDeleted = pstmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Inquiry deleted successfully.");
                } else {
                    System.out.println("Inquiry not found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error deleting inquiry: " + e.getMessage());
        }
    }
  }
