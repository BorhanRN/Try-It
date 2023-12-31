package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.UUID;

// represents an entry in a journal having a title, rating and description
public class Page implements Writable {
    private String title;
    private int rating;
    private String description;

    // MODIFIES: this
    // EFFECTS: initialize title, rating, description
    public Page(String title, int rating, String description) {
        this.title = title;
        this.rating = rating;
        this.description = description;
    }


    // MODIFIES: this
    // EFFECTS: changes a title
    public String changeTitle(String newTitle) {
        this.title = newTitle;
        return this.title;
    }

    // REQUIRES: rating must be [1, 10]
    // MODIFIES: this
    // EFFECTS: changes a rating
    public int changeRating(int newRating) {
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
        return title;
    }

    // EFFECTS: returns pages rating
    public int getRating() {
        return rating;
    }

    // EFFECTS: returns pages description
    public String getDescription() {
        return description;
    }

    //EFFECTS: converts page to json
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("rating", rating);
        json.put("description", description);
        return json;
    }
}
