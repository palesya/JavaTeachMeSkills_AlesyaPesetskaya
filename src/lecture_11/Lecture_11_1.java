package lecture_11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Lecture_11_1 {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("hello.txt");
            int read = fis.read();
        } catch (FileNotFoundException | NullPointerException exc) {
            System.out.println("File not found");
        } catch (IOException exc) {
            System.out.println("IO exception");
        } finally {
            try {
                fis.close();
            } catch (IOException|NullPointerException e) {
                System.out.println("Can't be closed");
            }
        }
    }
}
