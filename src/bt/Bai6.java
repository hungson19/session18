package bt;

import java.io.*;
import java.util.*;

public class Bai6 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập tên tệp văn bản: ");
            String fileName = scanner.nextLine();

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            Map<String, Integer> wordFrequency = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
            reader.close();

            // Tìm từ được sử dụng nhiều nhất
            int maxFrequency = 0;
            List<String> mostFrequentWords = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                int frequency = entry.getValue();
                if (frequency > maxFrequency) {
                    maxFrequency = frequency;
                    mostFrequentWords.clear();
                    mostFrequentWords.add(entry.getKey());
                } else if (frequency == maxFrequency) {
                    mostFrequentWords.add(entry.getKey());
                }
            }

            // Hiển thị từ được sử dụng nhiều nhất
            System.out.println("Các từ được sử dụng nhiều nhất:");
            for (String word : mostFrequentWords) {
                System.out.println(word + " (Tần suất: " + maxFrequency + ")");
            }
        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}

