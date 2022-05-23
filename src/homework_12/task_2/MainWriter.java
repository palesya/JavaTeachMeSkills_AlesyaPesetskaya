package homework_12.task_2;

import java.io.*;

public class MainWriter {
    public static void main(String[] args) throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader("src/homework_12/task_2/RomeoAndJuliet.txt"));
        FileWriter writerRomeo = new FileWriter("src/homework_12/task_2/Romeo.txt");
        FileWriter writerJuliet = new FileWriter("src/homework_12/task_2/Juliet.txt");

        String line = lnr.readLine();
        while (line != null) {
            if (line.startsWith("ROMEO")) {
                do {
                    writerRomeo.write(line + "\n");
                    line = lnr.readLine();
                    if (line == null) {
                        break;
                    }
                } while (!line.startsWith("JULIET"));
            } else if (line.startsWith("JULIET")) {
                do {
                    writerJuliet.write(line + "\n");
                    line = lnr.readLine();
                    if (line == null) {
                        break;
                    }
                } while (!line.startsWith("ROMEO"));
            } else {
                line = lnr.readLine();
            }
        }
        lnr.close();
        writerRomeo.close();
        writerJuliet.close();
    }
}
