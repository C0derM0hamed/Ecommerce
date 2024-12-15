package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Order;
import models.Product;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=ECommerceDB;encrypt=false";
    private static final String USER = "sa";
    private static final String PASSWORD = "123";

    // Private constructor for singleton instance
    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        // Check if the connection is closed, and re-establish it if needed
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void insertProduct(Product product) {
        String sql = "INSERT INTO products (name, category, price) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = getInstance().getConnection().prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getCategory());
            pstmt.setDouble(3, product.getPrice());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting product: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void insertProductIntoCard(Product product) {
        String sql = "INSERT INTO card ( name, category, price) VALUES ( ?, ?, ?)";
         try (PreparedStatement pstmt = getInstance().getConnection().prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getCategory());
            pstmt.setDouble(3, product.getPrice());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting product: " + e.getMessage());
            e.printStackTrace();
        }
    }
    //(String Location, double TotalPrice, String type)
    public void insertOrder(Order order)
    {
            String sql = "INSERT INTO Orderss (Location,TotalPrice,Type,CstmrName) VALUES ( ?, ?, ?, ?)";
         try (PreparedStatement pstmt = getInstance().getConnection().prepareStatement(sql)) {
            pstmt.setString(1, order.getLocation());
            pstmt.setDouble(2, order.getTotalPrice());
            pstmt.setString(3, order.getType());
            pstmt.setString(4, order.getCstmrName());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting product: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void closeConnection() {
        if (instance != null && instance.connection != null) {
            try {
                instance.connection.close();
                instance.connection = null; // Reset connection
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
