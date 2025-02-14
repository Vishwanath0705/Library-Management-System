import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RemoveBookView extends JFrame {
    private JTextField idField;
    private JButton removeButton;

    public RemoveBookView() {
        setTitle("Remove Book");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel idLabel = new JLabel("Book ID:");
        idLabel.setBounds(20, 50, 100, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(140, 50, 200, 25);
        add(idField);

        removeButton = new JButton("Remove Book");
        removeButton.setBounds(140, 100, 150, 30);
        add(removeButton);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int bookId = Integer.parseInt(idField.getText());
                    BookController.removeBook(bookId);
                    JOptionPane.showMessageDialog(null, "Book removed successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Book ID. Please enter a valid number.");
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error removing book.");
                }
            }
        });
        setLocationRelativeTo(null); 
        setVisible(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RemoveBookView();
    }
}
