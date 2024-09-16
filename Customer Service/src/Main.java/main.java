//package com.example.customerservice;

import customerservice.Inquiry_Management;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nCustomer Service Management System");
            System.out.println("1. Manage Inquiries");
            System.out.println("2. Manage Complaints");
            System.out.println("3. Manage Resolutions");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: manageInquiries();
//                case 2 -> manageComplaints();
//                case 3 -> manageResolutions();
                case 4 : {
                    System.out.println("Exiting the system. Goodbye!");
                    running = false;
                }
                default: System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void manageInquiries() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n--- Inquiry Management ---");
            System.out.println("1. Record a New Inquiry");
            System.out.println("2. View Inquiry Details");
            System.out.println("3. Update Inquiry Status");
            System.out.println("4. Delete an Inquiry");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            // Check if the next input is an integer before processing
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer after reading the integer

                switch (choice) {
                    case 1:
                        Inquiry_Management.recordInquiry();
                        break;
                    case 2:
                        Inquiry_Management.viewInquiryDetails();
                        break;
                    case 3:
                        Inquiry_Management.updateInquiryStatus();
                        break;
                    case 4:
                        Inquiry_Management.deleteInquiry();
                        break;
                    case 5:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice, please enter a number between 1 and 5.");
                        break;
                }
            } else {
                // If input is not an integer, clear the input and prompt again
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input to avoid infinite loop
            }
        } while (choice != 5);
    }
}
//    private static void manageComplaints() {
//        // Call Complaint Management methods here
//        System.out.println("Complaint Management Selected.");
//        // Implement the corresponding methods below
//    }
//
//    private static void manageResolutions() {
//        // Call Resolution Management methods here
//        System.out.println("Resolution Management Selected.");
//        // Implement the corresponding methods below
//    }
//}

