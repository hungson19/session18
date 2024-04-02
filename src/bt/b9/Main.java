package bt.b9;

public class Main {
    public static void main(String[] args) {
        // Tạo một đối tượng BookManager
        BookManager bookManager = new BookManager();

        // Thêm một số cuốn sách vào danh sách
        bookManager.addBook(new Book("C#", "Hung Son", "Hung Son", 29.99));
        bookManager.addBook(new Book("Python", "Giang Rong", "Kim Dong", 19.99));
        bookManager.addBook(new Book("Java", "Van Toan", "Giao Duc", 39.99));

        // Hiển thị danh sách các cuốn sách
        bookManager.displayAllBooks();

        // Cập nhật thông tin của một cuốn sách
        Book updatedBook = new Book("Python", "Tu No", "The Ky", 24.99);
        bookManager.updateBook(updatedBook);
        System.out.println("\nDanh sách sau khi cập nhật:");
        bookManager.displayAllBooks();

        // Xóa một cuốn sách khỏi danh sách
        bookManager.deleteBook("Java");
        System.out.println("\nDanh sách sau khi xóa:");
        bookManager.displayAllBooks();
    }
}

