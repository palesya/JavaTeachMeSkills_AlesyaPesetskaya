package lecture_12;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        OutputStream os = new BufferedOutputStream(new FileOutputStream("src/hello.txt"));
        os.write(100);
        os.write(101);
        os.close();

        InputStream is = new BufferedInputStream(new FileInputStream("src/hello.txt"));
        byte[] bytes = new byte[2];
        //is.read(bytes);
        //System.out.println(Arrays.toString(bytes));

        byte[] bytes1 = new byte[is.available()];
        is.read(bytes1);
        os.write(bytes1);
        String s = new String(bytes1);
        System.out.println(s);
    }
}
