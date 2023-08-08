package ui;

import model.Book;

import javax.swing.*;

public class ViewFrame extends JFrame {
    private Book book;
    private JFrame frame = new JFrame("View All Entries");
    JPanel panel = new JPanel();
    JLabel title = new JLabel();
    JLabel rating = new JLabel();
    JLabel description = new JLabel();

    private static final int WIDTH = 400;

    // EFFECTS: constructs ViewFrame
    public ViewFrame(Book book) {
        this.book = book;
        int size = book.size();

        frame.setSize(WIDTH, 100 + (size * 100));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setResizable(true);
        frame.setVisible(true);

        makePanel();
    }

    // MODIFIES: this
    // EFFECTS: displays all pages in book
    public void makePanel() {
        for (int i = 1; i < book.size() + 1; i++) {
            JLabel entryNum = new JLabel("Entry number " + i + ":");
            title = new JLabel("Title: " + book.getPage(i).getTitle());
            rating = new JLabel("Rating: " + book.getPage(i).getRating());
            description = new JLabel("Description: " + book.getPage(i).getDescription());
            JLabel spacer = new JLabel("-".repeat(WIDTH));

            panel.add(entryNum);
            panel.add(title);
            panel.add(rating);
            panel.add(description);
            panel.add(spacer);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        }
    }
}
