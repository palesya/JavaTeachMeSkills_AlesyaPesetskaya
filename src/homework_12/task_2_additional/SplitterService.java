package homework_12.task_2_additional;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitterService {
    String regex = "^[A-Z]*:";
    Pattern pattern = Pattern.compile(regex);

    public void splitTextToRoles(String path) throws IOException {
        Reader reader = new FileReader(path);
        LineNumberReader lnr = new LineNumberReader(reader);

        String line;
        String currentRole = null;

        FileWriter fw = null;
        while ((line = lnr.readLine()) != null) {

            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                if (!Objects.equals(matcher.group(), currentRole)) {
                    if (fw != null) fw.close();
                }
                currentRole = matcher.group();
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
                String fileName = formatter.format(calendar.getTime()) + currentRole.split(":")[0];
                File file = new File("src/homework_12/task_2_additional/" + fileName + ".txt");
                fw = new FileWriter(file, true);
                fw.write(line + "\n");
            } else {
                if (fw != null) {
                    fw.write(line + "\n");
                }
            }
        }

        if (fw != null) {
            fw.close();
        }

        lnr.close();
        reader.close();

    }
}

