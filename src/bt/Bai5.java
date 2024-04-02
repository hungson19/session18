package bt;

import java.io.*;
import java.util.*;

public class Bai5 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập tên tệp CSV: ");
            String fileName = scanner.nextLine();

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] countryInfo = line.split(",");
                if (countryInfo.length == 3) {
                    int id = Integer.parseInt(countryInfo[0]);
                    String code = countryInfo[1];
                    String name = countryInfo[2];
                    System.out.println(id + ". \"" + name + "\" (Mã: " + code + ")");
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}
