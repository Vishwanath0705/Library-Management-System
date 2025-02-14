import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IssueController {
    public static void issueBook(int bookId, int userId) throws ClassNotFoundException {
        try (Connection conn = JDBCConnection.getConnection()) {
            String query = "INSERT INTO issued_books (book_id, user_id) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, bookId);
            stmt.setInt(2, userId);
            stmt.executeUpdate();
            System.out.println("Book issued successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void returnBook(int bookId) throws ClassNotFoundException {
        try (Connection conn = JDBCConnection.getConnection()) {
            String query = "DELETE FROM issued_books WHERE book_id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, bookId);
            stmt.executeUpdate();
            System.out.println("Book returned successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
