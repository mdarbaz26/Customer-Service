package consumerElectronicsStoreManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        CustomerManager customerManager = new CustomerManager();
        OrderManager orderManager = new OrderManager();

        while (true) {
            System.out.println("\n--- Consumer Electronics Store Management System ---");
            System.out.println("1. Manage Products");
            System.out.println("2. Manage Customers");
            System.out.println("3. Manage Orders");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageProducts(scanner, productManager);
                    break;
                case 2:
                    manageCustomers(scanner, customerManager);
                    break;
                case 3:
                    manageOrders(scanner, orderManager);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Method to manage products
    private static void manageProducts(Scanner scanner, ProductManager productManager) {
        System.out.println("\n--- Product Management ---");
        System.out.println("1. Add Product");
        System.out.println("2. View Product");
        System.out.println("3. Update Product");
        System.out.println("4. Delete Product");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter product name: ");
                scanner.nextLine(); // consume newline
                String productName = scanner.nextLine();
                System.out.print("Enter product description: ");
                String productDescription = scanner.nextLine();
                System.out.print("Enter product price: ");
                double productPrice = scanner.nextDouble();
                System.out.print("Enter stock quantity: ");
                int stockQuantity = scanner.nextInt();
                productManager.addProduct(productName, productDescription, productPrice, stockQuantity);
                break;
            case 2:
                System.out.print("Enter product ID to view: ");
                int productId = scanner.nextInt();
                productManager.viewProduct(productId);
                break;
            case 3:
                System.out.print("Enter product ID to update: ");
                int updateProductId = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Enter new product name: ");
                String newProductName = scanner.nextLine();
                System.out.print("Enter new product description: ");
                String newProductDescription = scanner.nextLine();
                System.out.print("Enter new product price: ");
                double newProductPrice = scanner.nextDouble();
                System.out.print("Enter new stock quantity: ");
                int newStockQuantity = scanner.nextInt();
                productManager.updateProduct(updateProductId, newProductName, newProductDescription, newProductPrice, newStockQuantity);
                break;
            case 4:
                System.out.print("Enter product ID to delete: ");
                int deleteProductId = scanner.nextInt();
                productManager.deleteProduct(deleteProductId);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    // Method to manage customers
    private static void manageCustomers(Scanner scanner, CustomerManager customerManager) {
        System.out.println("\n--- Customer Management ---");
        System.out.println("1. Add Customer");
        System.out.println("2. View Customer");
        System.out.println("3. Update Customer");
        System.out.println("4. Delete Customer");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter customer name: ");
                scanner.nextLine(); // consume newline
                String customerName = scanner.nextLine();
                System.out.print("Enter customer email: ");
                String customerEmail = scanner.nextLine();
                System.out.print("Enter customer phone number: ");
                String customerPhone = scanner.nextLine();
                System.out.print("Enter customer address: ");
                String customerAddress = scanner.nextLine();
                customerManager.addCustomer(customerName, customerEmail, customerPhone, customerAddress);
                break;
            case 2:
                System.out.print("Enter customer ID to view: ");
                int customerId = scanner.nextInt();
                customerManager.viewCustomer(customerId);
                break;
            case 3:
                System.out.print("Enter customer ID to update: ");
                int updateCustomerId = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Enter new customer name: ");
                String newCustomerName = scanner.nextLine();
                System.out.print("Enter new customer email: ");
                String newCustomerEmail = scanner.nextLine();
                System.out.print("Enter new customer phone number: ");
                String newCustomerPhone = scanner.nextLine();
                System.out.print("Enter new customer address: ");
                String newCustomerAddress = scanner.nextLine();
                customerManager.updateCustomer(updateCustomerId, newCustomerName, newCustomerEmail, newCustomerPhone, newCustomerAddress);
                break;
            case 4:
                System.out.print("Enter customer ID to delete: ");
                int deleteCustomerId = scanner.nextInt();
                customerManager.deleteCustomer(deleteCustomerId);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    // Method to manage orders
    private static void manageOrders(Scanner scanner, OrderManager orderManager) {
        System.out.println("\n--- Order Management ---");
        System.out.println("1. Place Order");
        System.out.println("2. View Order");
        System.out.println("3. Update Order");
        System.out.println("4. Cancel Order");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter customer ID: ");
                int customerId = scanner.nextInt();
                System.out.print("Enter total amount: ");
                double totalAmount = scanner.nextDouble();
                System.out.print("Enter order status (pending/confirmed/shipped/delivered/cancelled): ");
                scanner.nextLine(); // consume newline
                String orderStatus = scanner.nextLine();
                orderManager.placeOrder(customerId, totalAmount, orderStatus);
                break;
            case 2:
                System.out.print("Enter order ID to view: ");
                int orderId = scanner.nextInt();
                orderManager.viewOrder(orderId);
                break;
            case 3:
                System.out.print("Enter order ID to update: ");
                int updateOrderId = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Enter new status: ");
                String newStatus = scanner.nextLine();
                orderManager.updateOrder(updateOrderId, newStatus);
                break;
            case 4:
                System.out.print("Enter order ID to cancel: ");
                int cancelOrderId = scanner.nextInt();
                orderManager.cancelOrder(cancelOrderId);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }
}
