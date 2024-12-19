package db;

// We use ADO (Active Data Object) to deal with database in our project

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
    }
 //retrieves the single instance of the DatabaseConnection
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
   //checks if there’s an active connection. if not optain one
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
    //prepares and executes an SQL query to insert a new product into the database.
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
   
   //prepares and executes an SQL query to insert a new order into the database. 
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
    
    //Closes the database connection when it's no longer needed.
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
