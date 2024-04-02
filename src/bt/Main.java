package bt;

import bt.b9.Book;
import bt.b9.BookManager;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Tạo một đối tượng BookManager
        BookManager bookManager = new BookManager();

        // Thêm một số cuốn sách vào danh sách
        bookManager.addBook(new Book("Java Programming", "John Doe", "ABC Publisher", 29.99));
        bookManager.addBook(new Book("Python Basics", "Jane Smith", "XYZ Publisher", 19.99));
        bookManager.addBook(new Book("Data Structures", "Alice Johnson", "DEF Publisher", 39.99));

        // Hiển thị danh sách các cuốn sách
        bookManager.displayAllBooks();

        // Cập nhật thông tin của một cuốn sách
        Book updatedBook = new Book("Python Basics", "Jane Smith", "XYZ Publisher", 24.99);
        bookManager.updateBook(updatedBook);
        System.out.println("\nDanh sách sau khi cập nhật:");
        bookManager.displayAllBooks();

        // Xóa một cuốn sách khỏi danh sách
        bookManager.deleteBook("Java Programming");
        System.out.println("\nDanh sách sau khi xóa:");
        bookManager.displayAllBooks();
    }
}
