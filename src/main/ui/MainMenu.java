package ui;

import model.Book;
import model.Event;
import model.EventLog;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import static java.lang.System.exit;

public class MainMenu extends JFrame implements ActionListener {
    protected Book book = new Book();
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/book.json";
    private JFrame frame = new JFrame("TRY it - Experience Tracker");
    private JPanel panel = new JPanel();

    private JButton addButton = new JButton("New Entry");
    private JButton removeButton = new JButton("Remove Entry");
    private JButton viewButton = new JButton("View An Entry");
    private JButton viewAllButton = new JButton("View All Entries");
    private JButton editButton = new JButton("Edit An Entry");
    private JButton saveButton = new JButton("Save");
    private JButton loadButton = new JButton("Load");
    private JButton quitButton = new JButton("Quit");
    public static final int WIDTH = 351;
    public static final int HEIGHT = 650;

    // EFFECTS: constructs initial menu
    public MainMenu() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);
        renderButtons();
    }

    // MODIFIES: this
    // EFFECTS: adds buttons to panel
    @SuppressWarnings("methodlength")
    public void renderButtons() {
        addButton.setBounds(5, 10, 325, 70);
        addButton.addActionListener(this);
        panel.add(addButton);

        removeButton.setBounds(5, 85, 325, 70);
        removeButton.addActionListener(this);
        panel.add(removeButton);

        viewButton.setBounds(5, 160, 325, 70);
        viewButton.addActionListener(this);
        panel.add(viewButton);

        viewAllButton.setBounds(5, 235, 325, 70);
        viewAllButton.addActionListener(this);
        panel.add(viewAllButton);

        editButton.setBounds(5, 310, 325, 70);
        editButton.addActionListener(this);
        panel.add(editButton);

        saveButton.setBounds(5, 385, 325, 70);
        saveButton.addActionListener(this);
        panel.add(saveButton);

        loadButton.setBounds(5, 460, 325, 70);
        loadButton.addActionListener(this);
        panel.add(loadButton);

        quitButton.setBounds(5, 535, 325, 70);
        quitButton.addActionListener(this);
        panel.add(quitButton);
    }

    // MODIFIES: this
    // EFFECTS: opens new corresponding frame based on the button pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            new NewEntryFrame(book);
        } else if (e.getSource() == removeButton) {
            new RemoveFrame(book);
        } else if (e.getSource() == viewButton) {
            new ViewSingleFrame(book);
        } else if (e.getSource() == viewAllButton) {
            new ViewFrame(book);
        } else if (e.getSource() == editButton) {
            new EditFrame(book);
        } else if (e.getSource() == saveButton) {
            saveInventory();
        } else if (e.getSource() == loadButton) {
            loadInventory();
        } else if (e.getSource() == quitButton) {
            printLog();
            quit();
        }
    }


    // EFFECTS: saves the inventory to file
    public void saveInventory() {
        try {
            jsonWriter.open();
            jsonWriter.write(book);
            jsonWriter.close();
            System.out.println("Saved inventory to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads inventory from file
    private void loadInventory() {
        try {
            book = jsonReader.read();
            System.out.println("Loaded all entries from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    public void printLog() {
        EventLog eventLog = EventLog.getInstance();
        for (Event event : eventLog) {
            System.out.println("\n");
            System.out.println(event);
        }
    }

    // EFFECTS: ends the program
    void quit() {
        exit(0);
    }
}
