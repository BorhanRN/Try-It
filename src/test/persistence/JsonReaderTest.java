package persistence;

import model.Page;
import model.Book;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Book book = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyBook() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyBook.json");
        try {
            Book book = reader.read();
            assertEquals(0, book.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralBook() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralBook.json");
        try {
            Book book = reader.read();
            List<Page> pages = book.getPages();
            assertEquals(2, pages.size());
            checkPage("abc", 5, "def", pages.get(0));
            checkPage("testing", 6, "test", pages.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}