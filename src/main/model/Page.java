package model;

import java.util.UUID;

// represents an entry in a journal having a title, rating and description
public class Page {
    private String title;
    private int rating;
    private String description;
    private String pageID;

    // MODIFIES: this
    // EFFECTS: initialize title, rating, description
    public Page(String title, int rating, String description) {
        this.title = title;
        this.rating = rating;
        this.description = description;
        this.pageID = UUID.randomUUID().toString();
    }

    // MODIFIES: this
    // EFFECTS: changes a title
    public String changeTitle(String newTitle) {
        this.title = newTitle;
        return this.title;
    }

    // MODIFIES: this
    // EFFECTS: changes a rating
    public int changeRating(int newRating) throws Exception {
        if (newRating < 1 || newRating > 10) {
            throw new Exception("invalid rating");
        }
        this.rating = newRating;
        return this.rating;
    }

    // MODIFIES: this
    // EFFECTS:changes a description
    public String changeDescription(String newDescription) {
        this.description = newDescription;
        return this.description;
    }

    // EFFECTS: returns pages title
    public String getTitle() {
        return this.title;
    }

    // EFFECTS: returns pages rating
    public int getRating() {
        return rating;
    }

    // EFFECTS: returns pages description
    public String getDescription() {
        return description;
    }

    // EFFECTS: returns pages random ID
    public String getPageID() {
        return pageID;
    }
}
