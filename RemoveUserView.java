import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveUserView extends JFrame {
    private JTextField idField;
    private JButton removeButton;

    public RemoveUserView() {
        setTitle("Remove User");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel idLabel = new JLabel("User ID:");
        idLabel.setBounds(20, 50, 100, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(140, 50, 200, 25);
        add(idField);

        removeButton = new JButton("Remove User");
        removeButton.setBounds(140, 100, 150, 30);
        add(removeButton);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userId = Integer.parseInt(idField.getText());
                    UserController.removeUser(userId);
                    JOptionPane.showMessageDialog(null, "User removed successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid User ID. Please enter a valid number.");
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error removing user.");
                }
            }
        });
        setLocationRelativeTo(null); 
        setVisible(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RemoveUserView();
    }
}
