package lecture_12;

import java.io.*;

public class Symbols {
    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("src/hello.txt");
        int read = reader.read();
        System.out.println((char) read);
        reader.close();

        LineNumberReader lnr=new LineNumberReader(new BufferedReader(new FileReader("src/hello.txt")));
        String s=lnr.readLine();

        while(s!=null){
            System.out.println(s);
            s=lnr.readLine();
        }
        lnr.close();

        Writer writer = new FileWriter("src/hello1.txt");
        BufferedWriter bw=new BufferedWriter(writer);
        writer.write("hello");
        writer.close();
        bw.close();

        PrintWriter pw=new PrintWriter(new FileWriter("src/hello1.txt"));
        pw.println("hello, world");
        pw.println("It's me");
        pw.close();

    }
}
