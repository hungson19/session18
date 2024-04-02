package bt;

import java.io.*;
import java.util.*;

public class Bai3 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập tên tệp văn bản: ");
            String fileName = scanner.nextLine();

            // Đọc nội dung từ tệp văn bản
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
            reader.close();

            // Tách thành các từ
            String[] words = content.toString().split("\\s+");

            // Tìm độ dài lớn nhất
            int maxLength = 0;
            List<String> longestWords = new ArrayList<>();
            for (String word : words) {
                int length = word.length();
                if (length > maxLength) {
                    maxLength = length;
                    longestWords.clear();
                    longestWords.add(word);
                } else if (length == maxLength) {
                    longestWords.add(word);
                }
            }

            // Hiển thị các từ có độ dài lớn nhất
            System.out.println("Các từ có độ dài lớn nhất:");
            for (String longestWord : longestWords) {
                System.out.println(longestWord + " (" + maxLength + " ký tự)");
            }
        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}

