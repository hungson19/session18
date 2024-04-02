package bt;
import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Bai7 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập tên tệp nhị phân: ");
            String fileName = scanner.nextLine();

            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            List<Object> objectList = new ArrayList<>();
            try {
                while (true) {
                    Object obj = objectInputStream.readObject();
                    objectList.add(obj);
                }
            } catch (EOFException e) {
                // End of file reached
            }

            objectInputStream.close();
            fileInputStream.close();

            // Hiển thị danh sách đối tượng
            for (Object obj : objectList) {
                System.out.println(obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}


