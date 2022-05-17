package lecture_11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Lecture_11_2 {
    public static void main(String[] args) throws FileNotFoundException {
        try (FileInputStream fis = new FileInputStream("hello.txt")) {
            int read = fis.read();
        } catch (IOException exc) {
            System.out.println("Can't be closed");
        }
    }
}
