import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddUserView extends JFrame {
    private JTextField nameField, emailField;
    private JButton addButton;

    public AddUserView() {
        setTitle("Add User");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel nameLabel = new JLabel("User Name:");
        nameLabel.setBounds(20, 40, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(140, 40, 200, 25);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 80, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(140, 80, 200, 25);
        add(emailField);

        addButton = new JButton("Add User");
        addButton.setBounds(140, 130, 150, 30);
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                try {
                    UserController.addUser(name, email);
                    JOptionPane.showMessageDialog(null, "User added successfully!");
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error adding user.");
                }
            }
        });
        setLocationRelativeTo(null); 
        setVisible(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddUserView();
    }
}
