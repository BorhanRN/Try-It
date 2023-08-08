package ui;

import model.Book;
import model.Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewSingleFrame extends JFrame implements ActionListener {
    private Book book;
    private JFrame frame = new JFrame("View An Entry");
    JPanel panel = new JPanel();
    JLabel selector = new JLabel("Which Entry Would You Like To View");
    JTextField entryNum = new JTextField("");
    JLabel title = new JLabel();
    JLabel rating = new JLabel();
    JLabel description = new JLabel();
    JButton button = new JButton("View");

    // EFFECTS: constructs ViewFrame
    public ViewSingleFrame(Book book) {
        this.book = book;

        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setResizable(true);
        frame.setVisible(true);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        makePanel();
    }

    // MODIFIES: this
    // EFFECTS: creates corresponding label and text field
    public void makePanel() {
        selector.setBounds(10, 10, 100, 50);
        panel.add(selector);
        entryNum.setBounds(10, 140, 50, 50);
        panel.add(entryNum);
        button.setBounds(80, 80, 100, 50);
        button.addActionListener(this);
        panel.add(button);

    }

    // MODIFIES: this
    // EFFECTS: displays the selected entry
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String num = entryNum.getText();
            frame.dispose();

            panel = new JPanel();
            frame = new JFrame();
            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(panel);
            frame.setResizable(true);
            frame.setVisible(true);

            title = new JLabel("Title: " + book.getPage(Integer.parseInt(num)).getTitle());
            rating = new JLabel("Rating: " + book.getPage(Integer.parseInt(num)).getRating());
            description = new JLabel("Description: " + book.getPage(Integer.parseInt(num)).getDescription());

            panel.add(title);
            panel.add(rating);
            panel.add(description);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        }
    }

}