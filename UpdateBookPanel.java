import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdateBookPanel extends JFrame {
    private JTextField bookIdField, nameField, authorField, quantityField;
    private JButton updateButton;

    public UpdateBookPanel() {
        setTitle("Update Book");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel bookIdLabel = new JLabel("Book ID:");
        bookIdLabel.setBounds(20, 20, 100, 25);
        add(bookIdLabel);

        bookIdField = new JTextField();
        bookIdField.setBounds(140, 20, 200, 25);
        add(bookIdField);

        JLabel nameLabel = new JLabel("New Name:");
        nameLabel.setBounds(20, 60, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(140, 60, 200, 25);
        add(nameField);

        JLabel authorLabel = new JLabel("New Author:");
        authorLabel.setBounds(20, 100, 100, 25);
        add(authorLabel);

        authorField = new JTextField();
        authorField.setBounds(140, 100, 200, 25);
        add(authorField);

        JLabel quantityLabel = new JLabel("New Quantity:");
        quantityLabel.setBounds(20, 140, 100, 25);
        add(quantityLabel);

        quantityField = new JTextField();
        quantityField.setBounds(140, 140, 200, 25);
        add(quantityField);

        updateButton = new JButton("Update Book");
        updateButton.setBounds(140, 180, 150, 30);
        add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bookId = Integer.parseInt(bookIdField.getText());

                try {
                    String bookDetails = BookController.getBookById(bookId);

                    if (bookDetails != null) {
                        String currentName = extractBookName(bookDetails);  
                        String currentAuthor = extractBookAuthor(bookDetails);  
                        int currentQuantity = extractBookQuantity(bookDetails);  
                        String newName = nameField.getText().isEmpty() ? currentName : nameField.getText();
                        String newAuthor = authorField.getText().isEmpty() ? currentAuthor : authorField.getText();
                        int newQuantity = quantityField.getText().isEmpty() ? currentQuantity : Integer.parseInt(quantityField.getText());

                        boolean success = BookController.updateBook(newName, newAuthor, newQuantity, bookId);

                        if (success) {
                            JOptionPane.showMessageDialog(null, "Book updated successfully!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error updating book.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Book not found.");
                    }

                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error fetching book details.");
                }
            }
        });

        setLocationRelativeTo(null); 
        setVisible(true);
    }

    private String extractBookName(String bookDetails) {
        return bookDetails.split(" | ")[1].trim();  
    }

    private String extractBookAuthor(String bookDetails) {
        return bookDetails.split(" by ")[1].trim();  
    }

    private int extractBookQuantity(String bookDetails) {
        return 10; 
    }

    public static void main(String[] args) {
        new UpdateBookPanel();
    }
}
