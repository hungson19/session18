package bt.b9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private static final String FILE_NAME = "books.dat";

    // Thêm một cuốn sách mới vào danh sách
    public void addBook(Book book) {
        List<Book> bookList = readBooksFromFile();
        bookList.add(book);
        writeBooksToFile(bookList);
    }

    // Cập nhật thông tin của một cuốn sách trong danh sách
    public void updateBook(Book book) {
        List<Book> bookList = readBooksFromFile();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().equals(book.getTitle())) {
                bookList.set(i, book);
                break;
            }
        }
        writeBooksToFile(bookList);
    }

    // Xóa một cuốn sách khỏi danh sách bằng cách sử dụng title (tên sách)
    public void deleteBook(String title) {
        List<Book> bookList = readBooksFromFile();
        bookList.removeIf(book -> book.getTitle().equals(title));
        writeBooksToFile(bookList);
    }

    // Hiển thị danh sách tất cả các cuốn sách trong file nhị phân
    public void displayAllBooks() {
        List<Book> bookList = readBooksFromFile();
        System.out.println("=== DANH SÁCH CÁC CUỐN SÁCH ===");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    // Đọc danh sách các cuốn sách từ file nhị phân
    List<Book> readBooksFromFile() {
        List<Book> bookList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            while (true) {
                try {
                    Book book = (Book) ois.readObject();
                    bookList.add(book);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return bookList;
    }

    // Ghi danh sách các cuốn sách vào file nhị phân
    private void writeBooksToFile(List<Book> bookList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            for (Book book : bookList) {
                oos.writeObject(book);
            }
            System.out.println("Danh sách các cuốn sách đã được ghi vào file " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
}

