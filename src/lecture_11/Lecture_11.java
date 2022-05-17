package lecture_11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Lecture_11 {
    public static void main(String[] args) throws FileNotFoundException {
        String[] text = new String[]{new String(), new String()};
        for (int i = 0; i <= text.length; i++) {
            try {
                System.out.println(text[i]);
            } catch (ArrayIndexOutOfBoundsException exc) {
                System.out.println(exc);
            }
            System.out.println("hello");
        }

        int a1 = 10;
        int a2 = 2;
        int result = 0;
        try {
            result = a1 / a2;
            System.out.println("-----------------------");
            FileInputStream fis=new FileInputStream("hello.txt");
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException exc) {
            result = -1;
        }catch (FileNotFoundException ex){
            System.out.println("File not found!");
        }finally {
            System.out.println("finally");
        }
        System.out.println(result);
    }
}
