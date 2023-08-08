package ui;

import model.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditFrame extends JFrame implements ActionListener {
    private Book book;
    private JFrame frame = new JFrame("Edit An Entry");
    JPanel panel = new JPanel();
    JLabel titleLabel = new JLabel("Try it!");
    JTextField title = new JTextField("Enter a new title");
    JLabel ratingLabel = new JLabel("Like it?");
    JTextField rating = new JTextField("Enter new rating out of 10");
    JLabel descriptionLabel = new JLabel("Describe it...");
    JTextField description = new JTextField("Enter new description");
    JTextField entryNum = new JTextField("");
    JButton button = new JButton("Done");


    // EFFECTS: constructs EditFrame
    public EditFrame(Book book) {
        this.book = book;
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);

        editEntry();
    }

    // MODIFIES: this
    // EFFECTS: constructs edit frame
    public void editEntry() {
        JLabel header = new JLabel("Which Entry Would You Like To Edit?");
        header.setBounds(10, 10, 150, 30);
        panel.add(header);
        entryNum.setBounds(200, 10, 50, 30);
        entryNum.setText("");
        panel.add(entryNum);

        titleLabel.setBounds(10, 50, 100, 30);
        panel.add(titleLabel);
        title.setBounds(150, 50, 100, 30);
        panel.add(title);

        ratingLabel.setBounds(10, 90, 100, 30);
        panel.add(ratingLabel);
        rating.setBounds(150, 90, 100, 30);
        panel.add(rating);

        descriptionLabel.setBounds(10, 130, 100, 30);
        panel.add(descriptionLabel);
        description.setBounds(150, 130, 100, 30);
        panel.add(description);

        button.setBounds(150, 190, 100, 10);
        panel.add(button);
        button.addActionListener(this);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    }


    // MODIFIES: this
    // EFFECTS: gets new text fields and applies edits to selected page
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String i = entryNum.getText();
            String t = title.getText();
            String r = rating.getText();
            String d = description.getText();
            book.editPage(Integer.parseInt(i), t, Integer.parseInt(r), d);
            frame.dispose();

            panel = new JPanel();
            frame = new JFrame();
            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(panel);
            frame.setResizable(true);
            frame.setVisible(true);

            JLabel successMessage = new JLabel("Page " + Integer.parseInt(i) + " successfully edited!");

            panel.add(successMessage);
            panel.setLayout(new GridBagLayout());
        }
    }
}
