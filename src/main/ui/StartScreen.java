package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends JFrame {
    private JPanel panel = new JPanel();
    private JButton menuButton = new JButton("Main Menu");

    // EFFECTS: constructs start screen
    public StartScreen() {
        super("Welcome!");

        menuButton.addActionListener(e -> {
            dispose();
            new MainMenu();
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(450, 300);
        add(panel);

        ImageIcon logo = new ImageIcon("data/logo.png");
        JLabel imageHeader = new JLabel(logo);

        panel.add(imageHeader);
        panel.add(menuButton);

        validate();
    }
}


