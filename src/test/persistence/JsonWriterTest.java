package persistence;

import model.Page;
import model.Book;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            Book book = new Book();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyBook() {
        try {
            Book book = new Book();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyBook.json");
            writer.open();
            writer.write(book);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyBook.json");
            book = reader.read();
            assertEquals(0, book.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralBook() {
        try {
            Book book = new Book();
            book.addPage(new Page("pow", 9, "boom"));
            book.addPage(new Page("test", 4, "write"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralBook.json");
            writer.open();
            writer.write(book);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralBook.json");
            book = reader.read();
            List<Page> pages = book.getPages();
            assertEquals(2, pages.size());
            checkPage("pow", 9, "boom", pages.get(0));
            checkPage("test", 4, "write", pages.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}