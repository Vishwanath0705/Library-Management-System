import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class AddBookView extends JFrame {
    private JTextField idField, nameField, authorField, quantityField;
    private JButton addButton;

    public AddBookView() {
        setTitle("Add Book");
        setSize(400, 300);  
        setLayout(null);

        JLabel idLabel = new JLabel("Book ID:");
        idLabel.setBounds(20, 20, 100, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(140, 20, 200, 25);
        add(idField);

        JLabel nameLabel = new JLabel("Book Name:");
        nameLabel.setBounds(20, 60, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(140, 60, 200, 25);
        add(nameField);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(20, 100, 100, 25);
        add(authorLabel);

        authorField = new JTextField();
        authorField.setBounds(140, 100, 200, 25);
        add(authorField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(20, 140, 100, 25);
        add(quantityLabel);

        quantityField = new JTextField();
        quantityField.setBounds(140, 140, 200, 25);
        add(quantityField);

        addButton = new JButton("Add Book");
        addButton.setBounds(140, 180, 150, 30);
        add(addButton);

        addButton.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            String author = authorField.getText();
            int quantity;

            try {
                quantity = Integer.parseInt(quantityField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Quantity must be a valid number.");
                return;
            }

            try {
                boolean success = BookController.addBook(id, name, author, quantity);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Book added successfully!");
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Error adding book.");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        });

        setLocationRelativeTo(null); 
        setVisible(true);
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        authorField.setText("");
        quantityField.setText("");
    }

    public static void main(String[] args) {
        new AddBookView();
    }
}
