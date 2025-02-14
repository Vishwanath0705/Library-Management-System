import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ForgotPassword extends JFrame {
    public ForgotPassword() {
        setTitle("Forgot Password");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblUsername = new JLabel("Username:");
        JTextField txtUsername = new JTextField(15);
        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField(15);
        JLabel lblNewPassword = new JLabel("New Password:");
        JPasswordField txtNewPassword = new JPasswordField(15);
        JButton btnUpdate = new JButton("Update");

        gbc.gridx = 0; gbc.gridy = 1;
        add(lblUsername, gbc);
        gbc.gridx = 1;
        add(txtUsername, gbc);
        gbc.gridx = 0; gbc.gridy = 2;
        
        add(lblNewPassword, gbc);
        gbc.gridx = 1;
        add(txtNewPassword, gbc);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        add(btnUpdate, gbc);

        btnUpdate.addActionListener((ActionEvent e) -> {
            try (Connection con = JDBCConnection.getConnection()) {
                String query = "UPDATE users SET password=? WHERE username=?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, new String(txtNewPassword.getPassword()));
                pst.setString(2, txtUsername.getText());

                int rowsUpdated = pst.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Password Updated Successfully!");
                    dispose();
                    new LibraryLogin();
                } else {
                    JOptionPane.showMessageDialog(null, "User Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        setVisible(true);
    }
}
