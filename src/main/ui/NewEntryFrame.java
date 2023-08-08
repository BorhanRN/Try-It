package ui;

import model.Book;
import model.Page;

import javax.swing.*;
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
        frame.setSize(225, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);

        addTitle();
        addRating();
        addDescription();
        addButton();
    }

    // MODIFIES: this
    // EFFECTS: creates title button and text field
    public void addTitle() {
        titleLabel.setBounds(10, 20, 100, 30);
        panel.add(titleLabel);
        title.setBounds(100, 20, 200, 30);
        panel.add(title);
    }

    // MODIFIES: this
    // EFFECTS: creates rating button and text field
    public void addRating() {
        ratingLabel.setBounds(10, 60, 100, 30);
        panel.add(ratingLabel);
        rating.setBounds(100, 600, 200, 30);
        panel.add(rating);
    }

    // MODIFIES: this
    // EFFECTS: creates description button and text field
    public void addDescription() {
        descriptionLabel.setBounds(10, 100, 100, 30);
        panel.add(descriptionLabel);
        description.setBounds(100, 100, 200, 30);
        panel.add(description);
    }

    //MODIFIES: this
    //EFFECTS: creates add button
    public void addButton() {
        addButton.setBounds(10, 140, 100, 30);
        addButton.addActionListener(this);
        panel.add(addButton);
    }


    //MODIFIES: this
    //EFFECTS: makes a new product and adds to the inventory
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String t = title.getText();
            String r = rating.getText();
            String d = description.getText();
            book.addPage(new Page(t, Integer.parseInt(r), d));
            frame.dispose();
        }
    }
}
