import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBookView extends JFrame {
    private JTextField bookIdField;
    private JButton returnButton;

    public ReturnBookView() {
        setTitle("Return Book");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel bookIdLabel = new JLabel("Book ID:");
        bookIdLabel.setBounds(20, 50, 100, 25);
        add(bookIdLabel);

        bookIdField = new JTextField();
        bookIdField.setBounds(140, 50, 200, 25);
        add(bookIdField);

        returnButton = new JButton("Return Book");
        returnButton.setBounds(140, 100, 150, 30);
        add(returnButton);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int bookId = Integer.parseInt(bookIdField.getText());
                    IssueController.returnBook(bookId);
                    JOptionPane.showMessageDialog(null, "Book returned successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Book ID. Please enter a valid number.");
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error returning book.");
                }
            }
        });
        setLocationRelativeTo(null); 
        setVisible(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ReturnBookView();
    }
}
