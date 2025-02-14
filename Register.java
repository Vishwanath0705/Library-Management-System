import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {
    public Register() {
        setTitle("Register");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel lblRegister = new JLabel("Register", SwingConstants.CENTER);
        lblRegister.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(lblRegister, gbc);
        
        JLabel lblUsername = new JLabel("Username:");
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        add(lblUsername, gbc);
        
        JTextField txtUsername = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 1;
        add(txtUsername, gbc);
        
        JLabel lblEmail = new JLabel("Email:");
        gbc.gridx = 0; gbc.gridy = 2;
        add(lblEmail, gbc);
        
        JTextField txtEmail = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 2;
        add(txtEmail, gbc);
       
        JLabel lblMobile = new JLabel("Mobile:");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1;
        add(lblMobile, gbc);
        
        JTextField txtMobile = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 3;
        add(txtMobile, gbc);
        
        JLabel lblPassword = new JLabel("Password:");
        gbc.gridx = 0; gbc.gridy = 4;
        add(lblPassword, gbc);
        
        JPasswordField txtNewPassword = new JPasswordField(15);
        gbc.gridx = 1; gbc.gridy = 4;
        add(txtNewPassword, gbc);
        
        JButton btnRegister = new JButton("Register");
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        add(btnRegister, gbc);
        
        setVisible(true);
        
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Registration Successful");

                dispose();
                
                LibraryLogin login = new LibraryLogin();
            }
        });

    }
    
   
    
    public static void main(String[] args) {
        new Register();
    }
}
