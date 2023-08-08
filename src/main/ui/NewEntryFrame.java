package ui;

import model.Book;
import model.Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewEntryFrame extends JFrame implements ActionListener {
    private Book book;
    private JFrame frame = new JFrame("Add New Entry");
    private JPanel panel = new JPanel();
    JLabel titleLabel = new JLabel("Try it!");
    JTextField title = new JTextField("What did you try today?");
    JLabel ratingLabel = new JLabel("Like it?");
    JTextField rating = new JTextField("Enter rating out of 10");
    JLabel descriptionLabel = new JLabel("Describe it...");
    JTextField description = new JTextField("Enter description");
    JButton addButton = new JButton("Add");

    // EFFECTS: constructs NewEntryFrame with buttons
    public NewEntryFrame(Book book) {
        this.book = book;
        frame.setSize(250, 250);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);

        makeNewEntry();
    }

    // MODIFIES: this
    // EFFECTS: creates title labels and text field corresponding to a new entry
    public void makeNewEntry() {
        titleLabel.setBounds(10, 20, 100, 30);
        panel.add(titleLabel);
        title.setBounds(100, 20, 200, 30);
        panel.add(title);

        ratingLabel.setBounds(10, 60, 100, 30);
        panel.add(ratingLabel);
        rating.setBounds(100, 600, 200, 30);
        panel.add(rating);

        descriptionLabel.setBounds(10, 100, 100, 30);
        panel.add(descriptionLabel);
        description.setBounds(100, 100, 200, 30);
        panel.add(description);

        addButton.setBounds(10, 140, 100, 30);
        addButton.addActionListener(this);
        panel.add(addButton);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    }


    // MODIFIES: this
    // EFFECTS: makes a new entry and adds to the book
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String t = title.getText();
            String r = rating.getText();
            String d = description.getText();
            book.addPage(new Page(t, Integer.parseInt(r), d));
            frame.dispose();

            panel = new JPanel();
            frame = new JFrame();
            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(panel);
            frame.setResizable(true);
            frame.setVisible(true);

            JLabel successMessage = new JLabel("Entry Successfully Added!");
            panel.add(successMessage);
            panel.setLayout(new GridBagLayout());
        }
    }
}
