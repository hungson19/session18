package bt;

import java.io.*;

public class Bai2 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Nhập tên tệp nguồn và tệp đích
            System.out.print("Nhập tên tệp nguồn: ");
            String sourceFileName = reader.readLine();
            System.out.print("Nhập tên tệp đích: ");
            String targetFileName = reader.readLine();

            // Tạo luồng đầu vào và đầu ra
            FileInputStream sourceFile = new FileInputStream(sourceFileName);
            FileOutputStream targetFile = new FileOutputStream(targetFileName);

            // Sao chép nội dung từ tệp nguồn sang tệp đích
            int byteRead;
            int totalBytes = 0;
            byte[] buffer = new byte[1024];
            while ((byteRead = sourceFile.read(buffer)) != -1) {
                targetFile.write(buffer, 0, byteRead);
                totalBytes += byteRead;
            }

            // Đóng luồng
            sourceFile.close();
            targetFile.close();

            System.out.println("Sao chép thành công! Số byte đã sao chép: " + totalBytes);
        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}
