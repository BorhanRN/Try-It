package ui;

import model.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveFrame extends JFrame implements ActionListener {
    private Book book;
    private JFrame frame = new JFrame("Remove An Entry");
    private JPanel panel = new JPanel();
    JLabel selector = new JLabel("Which Entry Would You Like To Remove");
    JTextField entryNum = new JTextField("");
    JButton button = new JButton("Remove");

    // EFFECTS: constructs RemoveFrame with buttons
    public RemoveFrame(Book book) {
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
    // EFFECTS: creates title label and text field
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
    // EFFECTS: removes an entry the book
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

            book.removePage(Integer.parseInt(num));

            JLabel successMessage = new JLabel("Entry " + Integer.parseInt(num) + " successfully removed!");

            panel.add(successMessage);
            panel.setLayout(new GridBagLayout());
        }
    }
}
