package Writer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

public class WriterService {

    public void read() throws IOException {
        LineNumberReader reader = new LineNumberReader(new FileReader("src/Writer/RomeoAndJuliet.txt"));
        FileWriter romeo = new FileWriter("src/Writer/Romeo.txt");
        FileWriter juliet = new FileWriter("src/Writer/Juliet.txt");
        String currentLine = reader.readLine();

        FileWriter writer = null;

        while (currentLine != null) {
            if (currentLine.startsWith("ROMEO:")) {
                writer = romeo;
            } else if (currentLine.startsWith("JULIET:")) {
                writer = juliet;
            }
            if (writer != null) {
                writer.write(currentLine+"\n");
            }
            currentLine = reader.readLine();
        }

        reader.close();
        romeo.close();
        juliet.close();
    }
}