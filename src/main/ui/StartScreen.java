package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends JFrame implements ActionListener {
    private JFrame frame = new JFrame("TRY it");
    private JPanel panel = new JPanel();
    private JButton menuButton = new JButton("Main Menu");

    public StartScreen() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 300);
        frame.add(panel);

        ImageIcon logo = new ImageIcon("data/logo.png");
        JLabel imageHeader = new JLabel(logo);

        panel.add(imageHeader);
        panel.add(menuButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuButton) {
            panel = new JPanel();
            frame = new JFrame();
            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(panel);
            frame.setResizable(true);
            frame.setVisible(true);
            frame.dispose();
        }
    }
}
