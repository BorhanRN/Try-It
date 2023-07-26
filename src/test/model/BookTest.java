package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    private Book testBook;

    @BeforeEach
    void runBefore() {
        testBook = new Book();
    }

    @Test
    void testAddPage() {
        Page page1 = new Page("abc", 5, "def");
        Page page2 = new Page("abc123", 5, "def456");
        assertEquals(1, testBook.addPage(page1));
        assertEquals(2, testBook.addPage(page2));


    }

    @Test
    void testRemoveFirstPage() {
        Page page1 = new Page("abc", 5, "def");
        Page page2 = new Page("title", 8, "test");
        Page page3 = new Page("hello", 4, "hi");

        testBook.addPage(page1);
        testBook.addPage(page2);
        testBook.addPage(page3);

        testBook.removePage(2);
        assertEquals(2, testBook.size());
    }


    @Test
    void testRemoveMultiplePage() {
        Page page1 = new Page("abc", 5, "def");
        Page page2 = new Page("title", 8, "test");
        Page page3 = new Page("hello", 4, "hi");

        testBook.addPage(page1);
        testBook.addPage(page2);
        testBook.addPage(page3);

        testBook.removePage(2);
        testBook.removePage(1);

        assertEquals(1, testBook.size());
    }

    @Test
    void testGetPage() {
        Page page1 = new Page("abc", 5, "def");
        Page page2 = new Page("title", 8, "test");
        Page page3 = new Page("hello", 4, "hi");

        testBook.addPage(page1);
        testBook.addPage(page2);
        testBook.addPage(page3);

        assertEquals(page1, testBook.getPage(1));
        assertEquals(page2, testBook.getPage(2));
        assertEquals(page3, testBook.getPage(3));
    }

    @Test
    void testEditPage() {
        Page page1 = new Page("abc", 5, "def");
        Page page2 = new Page("title", 8, "test");
        Page page3 = new Page("hello", 4, "hi");

        testBook.addPage(page1);
        testBook.addPage(page2);
        testBook.addPage(page3);

        assertEquals(page1, testBook.getPage(1));
        testBook.editPage(1, "edit abc", 6, "edit def");
        page1.changeTitle("edit abc");
        page1.changeRating(6);
        page1.changeDescription("edit def");
        assertEquals(page1, testBook.getPage(1));
    }


    @Test
    void TestSize() {
        assertEquals(0, testBook.size());
        Page page1 = new Page("abc", 5, "def");
        Page page2 = new Page("title", 8, "test");
        Page page3 = new Page("hello", 4, "hi");
        testBook.addPage(page1);
        assertEquals(1, testBook.size());
        testBook.addPage(page2);
        assertEquals(2, testBook.size());
        testBook.addPage(page3);
        assertEquals(3, testBook.size());
    }

}
