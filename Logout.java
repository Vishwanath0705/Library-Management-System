import javax.swing.*;

public class Logout {
    public static void performLogout(JFrame currentFrame) {
        int confirm = JOptionPane.showConfirmDialog(currentFrame, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            currentFrame.dispose(); 
            new LibraryLogin(); 
        }
    }
}
