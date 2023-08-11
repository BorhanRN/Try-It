package ui;

import model.Book;
import model.Page;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// journal application
public class TryItApp {
    private static final String JSON_STORE = "./data/book.json";
    private Book book;
    private Page page;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    // EFFECTS: runs the journal application
    public TryItApp() {
        runJournal();
    }

    // MODIFIES: this
    // EFFECTS: initializes books
    private void init() {
        book = new Book();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runJournal() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add page");
        System.out.println("\tr -> remove page");
        System.out.println("\tv -> view specific page");
        System.out.println("\tva -> view all pages");
        System.out.println("\te -> edit page");
        System.out.println("\ts -> save book to file");
        System.out.println("\tl -> load book from file");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            doAddPage();
        } else if (command.equals("r")) {
            doRemovePage();
        } else if (command.equals("v")) {
            doViewPage();
        } else if (command.equals("va")) {
            doViewAll();
        } else if (command.equals("e")) {
            doEditPage();
        } else if (command.equals("s")) {
            saveBook();
        } else if (command.equals("l")) {
            loadBook();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a new page
    private void doAddPage() {
        System.out.println("Give this page a title");
        String title = input.next();
        System.out.println("Give this page a rating from 1-10");
        int rating = input.nextInt();
        System.out.println("Give this page a description");
        String description = input.next();
        book.addPage(new Page(title, rating, description));
        System.out.println("This page was successfully added!");
        System.out.println(title);
        System.out.println(rating);
        System.out.println(description);

    }

    // REQUIRES: page to remove must exist; int remove - 1 !> book list length
    // MODIFIES: this
    // EFFECTS: removes an existing page
    private void doRemovePage() {
        System.out.println("Which page would you like to remove?");
        int remove = input.nextInt();
        if (remove > book.size()) {
            System.out.println("This page doesn't exist");
            return;
        }
        book.removePage(remove);
        System.out.println("Page was successfully removed!");
    }

    // REQUIRES: page to view must exist
    // MODIFIES: this
    // EFFECTS: opens an existing page
    private void doViewPage() {
        System.out.println("Which page would you like to view?");
        int view = input.nextInt();
        if (view > book.size()) {
            System.out.println("This page doesn't exist");
            return;
        }
        System.out.println(book.getPage(view).getTitle());
        System.out.println(book.getPage(view).getRating());
        System.out.println(book.getPage(view).getDescription());
    }

    // EFFECTS: prints all existing pages
    private void doViewAll() {
        for (int i = 0; i < book.size(); i++) {
            System.out.println("Entry " + (i + 1) + ":");
            System.out.println(book.getPages().get(i).getTitle());
            System.out.println(book.getPages().get(i).getRating());
            System.out.println(book.getPages().get(i).getDescription());
        }
    }

    // REQUIRES: page to edit must exist
    // MODIFIES: this
    // EFFECTS: edits an existing page
    private void doEditPage() {
        System.out.println("Which page would you like to edit?");
        int edit = input.nextInt();
        if (edit > book.size()) {
            System.out.println("This page doesn't exist");
            return;
        }
        System.out.println("Give this page a new title");
        String title = input.next();
        System.out.println("Give this page a new rating from 1-10");
        int rating = input.nextInt();
        System.out.println("Give this page a new description");
        String description = input.next();
        book.editPage(edit, title, rating, description);
    }

    // EFFECTS: saves the book to file
    private void saveBook() {
        try {
            jsonWriter.open();
            jsonWriter.write(book);
            jsonWriter.close();
            System.out.println("Saved " + "to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads book from file
    private void loadBook() {
        try {
            book = jsonReader.read();
            System.out.println("Loaded " + "from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


}
