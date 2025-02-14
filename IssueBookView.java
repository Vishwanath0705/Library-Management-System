import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class IssueBookView extends JFrame {
    private JTextField bookIdField, userIdField;
    private JButton issueButton;

    public IssueBookView() {
        setTitle("Issue Book");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel bookIdLabel = new JLabel("Book ID:");
        bookIdLabel.setBounds(20, 20, 100, 25);
        add(bookIdLabel);

        bookIdField = new JTextField();
        bookIdField.setBounds(140, 20, 200, 25);
        add(bookIdField);

        JLabel userIdLabel = new JLabel("User ID:");
        userIdLabel.setBounds(20, 60, 100, 25);
        add(userIdLabel);

        userIdField = new JTextField();
        userIdField.setBounds(140, 60, 200, 25);
        add(userIdField);

        issueButton = new JButton("Issue Book");
        issueButton.setBounds(140, 100, 150, 30);
        add(issueButton);

        issueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bookId = Integer.parseInt(bookIdField.getText());
                int userId = Integer.parseInt(userIdField.getText());

                try {
                    IssueController.issueBook(bookId, userId);
                    JOptionPane.showMessageDialog(null, "Book issued successfully!");
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Error issuing book: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
        setLocationRelativeTo(null); 
        setVisible(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new IssueBookView();
    }
}
