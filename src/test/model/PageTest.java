package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageTest {
    private Page testPage;
    private String title = "Today";
    private int rating = 10;
    private String description = "a good day";

    @BeforeEach
    void runBefore() {
        testPage = new Page(title, rating, description);
    }

    @Test
    void testConstructor() {
        assertEquals("Today", testPage.getTitle());
        assertEquals(10, testPage.getRating());
        assertEquals("a good day", testPage.getDescription());
    }

    @Test
    void testChangeTitle() {
        testPage.changeTitle("this day");
        assertEquals("this day", testPage.getTitle());

        testPage.changeTitle("day 1");
        testPage.changeTitle("day 0");
        assertEquals("day 0", testPage.getTitle());
    }

    @Test
    void testChangeRating() {
        testPage.changeRating(5);
        assertEquals(5, testPage.getRating());

        testPage.changeRating(7);
        testPage.changeRating(9);
        assertEquals(9, testPage.getRating());
    }

    @Test
    void testChangeDescription() {
        testPage.changeDescription("a GREAT day");
        assertEquals("a GREAT day", testPage.getDescription());

        testPage.changeDescription("a day");
        testPage.changeDescription("the best day");
        assertEquals("the best day", testPage.getDescription());
    }

}