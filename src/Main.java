import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> countries = Arrays.asList("Australia", "China", "Japan", "Thailand");

            FileOutputStream fileOutputStream = new FileOutputStream("countries.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (String country : countries) {
                objectOutputStream.writeObject(country);
            }

            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("Tạo tệp nhị phân thành công: countries.dat");
        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}
