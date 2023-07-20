package ui;

import model.Book;
import model.Page;

import java.util.Scanner;

// journal application
public class JournalApp {

    private Book book;
    private Scanner input;

    // EFFECTS: runs the teller application
    public JournalApp() {
        runJournal();
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        book = new Book();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
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
        System.out.println("\tv -> view page");
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
        book.removePage(remove);
        System.out.println("Page was successfully removed!");
    }


    // REQUIRES: page to view must exist
    // MODIFIES: this
    // EFFECTS: opens an existing page
    private void doViewPage() {
        System.out.println("Which page would you like to view?");
        int view = input.nextInt();
        System.out.println(book.getPage(view).getTitle());
        System.out.println(book.getPage(view).getRating());
        System.out.println(book.getPage(view).getDescription());
    }

}

/*
 System.out.println("\te -> edit page");

 else if (command.equals("e")) {
            doEditPage();

// REQUIRES: page to edit must exist
    // MODIFIES: this
    // EFFECTS: edits an existing page
    private void doEditPage() {
        System.out.println("Which page would you like to edit?");
        int edit = input.nextInt();
        book.editPage(edit);

        System.out.println("Give this page a new title");
        String title = input.next();
        System.out.println("Give this page a new rating from 1-10");
        int rating = input.nextInt();
        System.out.println("Give this page a new description");
        String description = input.next();

        book.editPage(title, rating, description);

    }
 */