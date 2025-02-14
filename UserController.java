

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserController {
    public static void addUser(String name, String email) throws ClassNotFoundException, SQLException {
        Connection connection = JDBCConnection.getConnection();
        try {
            String query = "INSERT INTO users (name, email) VALUES (?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            System.out.println("User added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void removeUser(int userId) throws ClassNotFoundException {
        try (Connection conn = JDBCConnection.getConnection()) {
            String query = "DELETE FROM users WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            stmt.executeUpdate();
            System.out.println("User removed successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}
