import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LibraryLogin extends JFrame {
    public LibraryLogin() {
        setTitle("Library Management System - Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblLogin = new JLabel("Login", SwingConstants.CENTER);
        lblLogin.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lblLogin, gbc);

        JLabel lblUsername = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(lblUsername, gbc);

        JTextField txtUsername = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtUsername, gbc);

        JLabel lblPassword = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblPassword, gbc);

        JPasswordField txtPassword = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(txtPassword, gbc);

        JButton btnLogin = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(btnLogin, gbc);

        JButton btnForgotPassword = new JButton("Forgot Password?");
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(btnForgotPassword, gbc);

        JButton btnRegister = new JButton("Register");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(btnRegister, gbc);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                try (Connection con = JDBCConnection.getConnection()) {
                    String query = "SELECT * FROM users WHERE username=? AND password=?";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, username);
                    pst.setString(2, password);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Login Successful!");
                        AdminPanel adminPanel = new AdminPanel();
                        adminPanel.setLocationRelativeTo(LibraryLogin.this);  
                        adminPanel.setVisible(true);
                        dispose();  

                        
                        String logQuery = "INSERT INTO login_history (username) VALUES (?)";
                        PreparedStatement logStmt = con.prepareStatement(logQuery);
                        logStmt.setString(1, username);
                        logStmt.executeUpdate();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnForgotPassword.addActionListener(e -> new ForgotPassword());
        btnRegister.addActionListener(e -> new Register());

        setVisible(true);
    }

    public static void main(String[] args) {
        new LibraryLogin();
    }
}
