import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JFrame {
    public AdminPanel() {
        setTitle("Admin Panel");
        setSize(400, 500); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel bookPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        bookPanel.setBorder(BorderFactory.createTitledBorder("Book Management"));
        
        JPanel userPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        userPanel.setBorder(BorderFactory.createTitledBorder("User Management"));
        
        JPanel issuePanel = new JPanel(new GridLayout(2, 1, 5, 5));
        issuePanel.setBorder(BorderFactory.createTitledBorder("Issue/Return"));

        JButton addBookBtn = new JButton("Add Book");
        JButton removeBookBtn = new JButton("Remove Book");
        JButton updateBookBtn = new JButton("Update Book");
        JButton viewBooksBtn = new JButton("View Books");

        addBookBtn.addActionListener(e -> new AddBookView());
        removeBookBtn.addActionListener(e -> new RemoveBookView());
        updateBookBtn.addActionListener(e -> new UpdateBookPanel());
        viewBooksBtn.addActionListener(e -> {
            try {
                new ViewBooksView();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        });

        bookPanel.add(addBookBtn);
        bookPanel.add(removeBookBtn);
        bookPanel.add(updateBookBtn);
        bookPanel.add(viewBooksBtn);

        JButton addUserBtn = new JButton("Add User");
        JButton removeUserBtn = new JButton("Remove User");

        addUserBtn.addActionListener(e -> new AddUserView());
        removeUserBtn.addActionListener(e -> new RemoveUserView());

        userPanel.add(addUserBtn);
        userPanel.add(removeUserBtn);

        JButton issueBookBtn = new JButton("Issue Book");
        JButton returnBookBtn = new JButton("Return Book");

        issueBookBtn.addActionListener(e -> new IssueBookView());
        returnBookBtn.addActionListener(e -> new ReturnBookView());

        issuePanel.add(issueBookBtn);
        issuePanel.add(returnBookBtn);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(userPanel);
        centerPanel.add(issuePanel);

        add(bookPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER); 
        add(logoutPanel(), BorderLayout.PAGE_END); 

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel logoutPanel() {
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> Logout.performLogout(this)); 
        JPanel logoutPanel = new JPanel();
        logoutPanel.add(logoutButton);
        return logoutPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminPanel());
    }
}
