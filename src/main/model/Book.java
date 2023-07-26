package model;

import java.util.ArrayList;

// a list of pages
public class Book {
    private ArrayList<Page> pages;
    private Page page;


    public Book() {
        this.pages = new ArrayList();
    }

    // MODIFIES: this
    // EFFECTS: adds new page onto pages
    public int addPage(Page page) {
        pages.add(page);
        return this.pages.size();
    }

    // REQUIRES: selected page must exist, pageNum > 0
    // MODIFIES: this
    // EFFECTS: removes selected page from pages
    public void removePage(int pageNum) {
        pages.remove(pageNum - 1);
    }

    // REQUIRES: selected page must exist
    // EFFECTS: returns selected page from pages
    public Page getPage(int pageNum) {
        return this.pages.get(pageNum - 1);
    }


    public int size() {
        return pages.size();
    }

    // REQUIRES: selected page must exist
    // MODIFIES: this
    // EFFECTS: edits an existing page
    public void editPage(int i, String title, int rating, String description) {
        --i;
        pages.get(i).changeTitle(title);
        pages.get(i).changeRating(rating);
        pages.get(i).changeDescription(description);
    }
}