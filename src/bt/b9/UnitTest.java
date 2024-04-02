package bt.b9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UnitTest {

    @Test
    public void testAddBook() {
        BookManager bookManager = new BookManager();
        Book book = new Book("Test Book", "Test Author", "Test Publisher", 9.99);
        bookManager.addBook(book);
        List<Book> bookList = bookManager.readBooksFromFile();
        Assertions.assertTrue(bookList.contains(book));
    }

    @Test
    public void testUpdateBook() {
        BookManager bookManager = new BookManager();
        Book book = new Book("Test Book", "Test Author", "Test Publisher", 9.99);
        bookManager.addBook(book);
        Book updatedBook = new Book("Test Book", "Updated Author", "Updated Publisher", 19.99);
        bookManager.updateBook(updatedBook);
        List<Book> bookList = bookManager.readBooksFromFile();
        Assertions.assertTrue(bookList.contains(updatedBook));
    }

    @Test
    public void testDeleteBook() {
        BookManager bookManager = new BookManager();
        Book book = new Book("Test Book", "Test Author", "Test Publisher", 9.99);
        bookManager.addBook(book);
        bookManager.deleteBook("Test Book");
        List<Book> bookList = bookManager.readBooksFromFile();
        Assertions.assertFalse(bookList.contains(book));
    }
}

