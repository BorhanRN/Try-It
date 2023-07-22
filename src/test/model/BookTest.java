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
    void testRemovePages() {
        Page page1 = new Page("abc", 5, "def");
        Page page2 = new Page("title", 8, "test");
        Page page3 = new Page("hello", 4, "hi");


        // @Test
        // void testGetPages() {
        //}
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
