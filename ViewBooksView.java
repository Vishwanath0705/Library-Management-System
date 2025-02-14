
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewBooksView extends JFrame {
    public ViewBooksView() throws ClassNotFoundException {
        setTitle("View Books");
        setSize(400, 300);
        setLayout(new BorderLayout());

        JTextArea bookList = new JTextArea();
        bookList.setEditable(false);
        
        List<String> books = BookController.getBooks();
        for (String book : books) {
            bookList.append(book + "\n");
        }

        add(new JScrollPane(bookList), BorderLayout.CENTER);
        setLocationRelativeTo(null); 
        setVisible(true);
        setVisible(true);
    }
}
