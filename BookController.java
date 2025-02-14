import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookController {

    public static boolean addBook(String id, String name, String author, int quantity) throws SQLException, ClassNotFoundException {
        try (Connection conn = JDBCConnection.getConnection()) {
            String query = "INSERT INTO books (id, name, author, quantity, available) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, id);  // Set Book ID
            stmt.setString(2, name); // Set Book Name
            stmt.setString(3, author); // Set Author Name
            stmt.setInt(4, quantity);  // Set Quantity
            stmt.setInt(5, quantity);  // Set Available quantity (same as quantity initially)
            
            return stmt.executeUpdate() > 0;
        }
    }

    // Method to update an existing book
    public static boolean updateBook(String newName, String newAuthor, int newQuantity, int bookId) throws SQLException, ClassNotFoundException {
        try (Connection conn = JDBCConnection.getConnection()) {
            String query = "UPDATE books SET name = ?, author = ?, quantity = ?, available = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, newName);
            stmt.setString(2, newAuthor);
            stmt.setInt(3, newQuantity);
            stmt.setInt(4, newQuantity); 
            stmt.setInt(5, bookId);
            return stmt.executeUpdate() > 0;
        }
    }

    public static boolean removeBook(int bookId) throws SQLException, ClassNotFoundException {
        try (Connection conn = JDBCConnection.getConnection()) {
            String query = "DELETE FROM books WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, bookId);
            return stmt.executeUpdate() > 0;
        }
    }

    public static List<String> getBooks() throws ClassNotFoundException {
        List<String> books = new ArrayList<>();

        try (Connection conn = JDBCConnection.getConnection()) {
            String query = "SELECT * FROM books";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                books.add("ID: " + rs.getInt("id") + " | " + rs.getString("name") + " by " + rs.getString("author"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public static String getBookById(int bookId) throws SQLException, ClassNotFoundException {
        try (Connection conn = JDBCConnection.getConnection()) {
            String query = "SELECT * FROM books WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, bookId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return "ID: " + rs.getInt("id") + " | " + rs.getString("name") + " by " + rs.getString("author");
            } else {
                return null; 
            }
        }
    }

	
}
