package persistence;

import model.Page;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkPage(String title, int rating, String description, Page page) {
        assertEquals(title, page.getTitle());
        assertEquals(rating, page.getRating());
        assertEquals(description, page.getDescription());
    }
}
