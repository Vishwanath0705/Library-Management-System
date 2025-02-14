import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "skullboxml";
        String password = "Vishwanath@26";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Create Database
            String createDatabase = "CREATE DATABASE IF NOT EXISTS library_db";
            stmt.executeUpdate(createDatabase);
            System.out.println("Database created successfully");

            stmt.executeUpdate("USE library_db");

            // Users Table
            String createUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "username VARCHAR(50) UNIQUE NOT NULL, " +
                    "email VARCHAR(100) UNIQUE NOT NULL, " +
                    "mobile VARCHAR(15), " +
                    "password VARCHAR(100) NOT NULL)";
            stmt.executeUpdate(createUsersTable);
            System.out.println("Users table created successfully");

            // Admin Table
            String createAdminTable = "CREATE TABLE IF NOT EXISTS admin (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "username VARCHAR(50) UNIQUE NOT NULL, " +
                    "password VARCHAR(100) NOT NULL)";
            stmt.executeUpdate(createAdminTable);
            System.out.println("Admin table created successfully");

            // Books Table
            String createBooksTable = "CREATE TABLE IF NOT EXISTS books (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(255) NOT NULL, " +
                    "author VARCHAR(255) NOT NULL, " +
                    "quantity INT NOT NULL, " +
                    "available INT NOT NULL DEFAULT 0)";
            stmt.executeUpdate(createBooksTable);
            System.out.println("Books table created successfully");

            // Issued Books Table
            String createIssuedBooksTable = "CREATE TABLE IF NOT EXISTS issued_books (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "user_id INT, " +
                    "book_id INT, " +
                    "issue_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                    "return_date DATE, " +
                    "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE, " +
                    "FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE)";
            stmt.executeUpdate(createIssuedBooksTable);
            System.out.println("Issued Books table created successfully");

            // Returned Books Table
            String createReturnedBooksTable = "CREATE TABLE IF NOT EXISTS returned_books (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "user_id INT, " +
                    "book_id INT, " +
                    "return_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                    "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE, " +
                    "FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE)";
            stmt.executeUpdate(createReturnedBooksTable);
            System.out.println("Returned Books table created successfully");

            // Login History Table
            String createLoginHistoryTable = "CREATE TABLE IF NOT EXISTS login_history (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "username VARCHAR(50), " +
                    "login_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
            stmt.executeUpdate(createLoginHistoryTable);
            System.out.println("Login history table created successfully");
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
