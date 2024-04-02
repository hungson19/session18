package bt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Bai1 {
    public static void main(String[] args) {
        // Bước 1: Tạo đường dẫn của file text chứa dữ liệu
        String filePath = "data.txt";

        // Bước 2: Đọc nội dung từ file text
        String content = readFile(filePath);

        // Bước 3: Chia chuỗi thành các từ và đếm số lượng từ
        int wordCount = countWords(content);

        // Hiển thị số lượng từ trong file
        System.out.println("Số lượng từ trong file: " + wordCount);
    }

    // Bước 2: Đọc nội dung từ file text
    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    // Bước 3: Chia chuỗi thành các từ và đếm số lượng từ
    public static int countWords(String content) {
        if (content == null || content.isEmpty()) {
            return 0;
        }
        // Loại bỏ các ký tự không cần thiết và chia chuỗi thành các từ
        String[] words = content.trim().split("\\s+");
        return words.length;
    }
}

