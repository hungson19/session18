package bt;

import java.io.*;
import java.util.*;

public class Bai4 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập tên tệp văn bản gốc: ");
            String sourceFileName = scanner.nextLine();
            System.out.print("Nhập tên tệp văn bản đích: ");
            String targetFileName = scanner.nextLine();

            // Đọc nội dung từ tệp văn bản gốc
            BufferedReader reader = new BufferedReader(new FileReader(sourceFileName));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
            reader.close();

            // Tách thành các từ
            String[] words = content.toString().split("\\s+");

            // Đảo ngược thứ tự các từ
            StringBuilder reversedContent = new StringBuilder();
            for (String word : words) {
                StringBuilder reversedWord = new StringBuilder(word).reverse();
                reversedContent.append(reversedWord).append(" ");
            }

            // Ghi vào tệp văn bản đích
            BufferedWriter writer = new BufferedWriter(new FileWriter(targetFileName));
            writer.write(reversedContent.toString());
            writer.close();

            System.out.println("Tạo bản sao thành công với tên: " + targetFileName);
        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}

