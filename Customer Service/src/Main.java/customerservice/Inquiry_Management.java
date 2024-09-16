package customerservice;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class Inquiry_Management {
    // Method to record a new inquiry
    public static void recordInquiry() {
        try {
            // Establish database connection
            Connection conn = DBConnection.getConnection();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Customer ID: ");
            int customerId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left by nextInt()

            System.out.print("Enter Inquiry Date (YYYY-MM-DD): ");
            String inquiryDate = scanner.nextLine();

            System.out.print("Enter Description: ");
            String description = scanner.nextLine();

//            System.out.print("Enter Status: ");
//            String status = scanner.nextLine();

            // SQL query to insert the inquiry details into the database
            String sql = "INSERT INTO Inquiry ( complaint, customer, inquiry ) VALUES ('abcd','hfdh','jfjf')";

            // Prepare the statement and set the parameters
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customerId);
            pstmt.setDate(2, Date.valueOf(inquiryDate)); // Convert string to SQL date
            pstmt.setString(3, description);
//            pstmt.setString(4, status);

            // Execute the update
            pstmt.executeUpdate();
            System.out.println("Inquiry recorded successfully.");
        } catch (SQLException e) {
            System.out.println("Error recording inquiry: " + e.getMessage());
        }
    }

    // Placeholder method for viewing inquiry details
    public static void viewInquiryDetails() {
        // Implementation will go here
    }

    // Placeholder method for updating inquiry status
    public static void updateInquiryStatus() {
        // Implementation will go here
    }

    // Placeholder method for deleting an inquiry
    public static void deleteInquiry() {
        // Implementation will go here
    }
}
