package lecture_17;

import java.io.IOException;
import java.io.InputStream;

public class MainReflex {
    public static void main(String[] args) throws IOException {

        Runtime runtime = Runtime.getRuntime();
        Process exec = runtime.exec("javac src/Hello.java");
        InputStream errorStream = exec.getErrorStream();

    }
}
