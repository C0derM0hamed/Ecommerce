package ecommerceapp;
import db.DatabaseConnection;
import javax.swing.SwingUtilities;
import ui.MainUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/*
 * @author mohamedmostafa,
 * Yasmeen Elewa,
 * Tarek Abdallah,
 * Asmaa Khaled,
 * Carol Moussa   
 */
public class ECommerceApp {

    public static void main(String[] args) throws SQLException {
    SwingUtilities.invokeLater(() -> new MainUI().setVisible(true));
    
    }
    
}
