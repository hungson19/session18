package bt;

import java.io.*;
import java.util.*;

// Lớp Product đại diện cho thông tin của mỗi sản phẩm
class Product implements Serializable {
    private String productCode;
    private String productName;
    private String manufacturer;
    private double price;
    private String description;

    // Constructor
    public Product(String productCode, String productName, String manufacturer, double price, String description) {
        this.productCode = productCode;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.price = price;
        this.description = description;
    }

    // Getters và setters
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Hiển thị thông tin sản phẩm
    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}

public class Bai8 {
    private static final String FILE_NAME = "products.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();

        // Đọc thông tin sản phẩm từ file (nếu có)
        productList.addAll(readProductsFromFile());

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("4. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct(scanner, productList);
                    break;
                case 2:
                    displayProducts(productList);
                    break;
                case 3:
                    searchProduct(scanner, productList);
                    break;
                case 4:
                    // Ghi danh sách sản phẩm vào file trước khi thoát
                    writeProductsToFile(productList);
                    System.out.println("Đã ghi danh sách sản phẩm vào file " + FILE_NAME);
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    // Phương thức thêm sản phẩm
    private static void addProduct(Scanner scanner, List<Product> productList) {
        System.out.println("\n=== THÊM SẢN PHẨM ===");
        System.out.print("Nhập mã sản phẩm: ");
        String productCode = scanner.next();
        scanner.nextLine(); // Đọc bỏ dòng new line

        System.out.print("Nhập tên sản phẩm: ");
        String productName = scanner.nextLine();

        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Đọc bỏ dòng new line

        System.out.print("Nhập mô tả sản phẩm: ");
        String description = scanner.nextLine();

        // Tạo đối tượng sản phẩm mới và thêm vào danh sách
        Product newProduct = new Product(productCode, productName, manufacturer, price, description);
        productList.add(newProduct);
        System.out.println("Sản phẩm đã được thêm vào danh sách.");
    }

    // Phương thức hiển thị danh sách sản phẩm
    private static void displayProducts(List<Product> productList) {
        System.out.println("\n=== DANH SÁCH SẢN PHẨM ===");
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
        } else {
            for (Product product : productList) {
                System.out.println(product);
            }
        }
    }

    // Phương thức tìm kiếm sản phẩm
    private static void searchProduct(Scanner scanner, List<Product> productList) {
        System.out.println("\n=== TÌM KIẾM SẢN PHẨM ===");
        System.out.print("Nhập mã sản phẩm cần tìm: ");
        String searchCode = scanner.next();

        boolean found = false;
        for (Product product : productList) {
            if (product.getProductCode().equalsIgnoreCase(searchCode)) {
                System.out.println("Sản phẩm được tìm thấy:");
                System.out.println(product);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sản phẩm với mã " + searchCode);
        }
    }

    // Phương thức đọc danh sách sản phẩm từ file
    private static List<Product> readProductsFromFile() {
        List<Product> productList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            while (true) {
                try {
                    Product product = (Product) ois.readObject();
                    productList.add(product);
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println("Đã đọc danh sách sản phẩm từ file " + FILE_NAME);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Không tìm thấy file " + FILE_NAME + ". Tạo file mới.");
        }
        return productList;
    }

    // Phương thức ghi danh sách sản phẩm vào file
    private static void writeProductsToFile(List<Product> productList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            for (Product product : productList) {
                oos.writeObject(product);
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
}

