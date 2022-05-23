package homework_12.task_2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitterService {

    public void splitTextByRoles(String path) throws IOException {

        Pattern pattern = Pattern.compile("^[A-Z]*:");
        String line;
        String currentRole = null;

        LineNumberReader lnr = new LineNumberReader(new FileReader(path));
        String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

        while ((line = lnr.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                if (!Objects.equals(matcher.group(), currentRole)) {
                    currentRole = matcher.group();
                }
            } else if (currentRole == null) {
                continue;
            }
            String fileName = currentDate + currentRole.split(":")[0];
            File file = new File("src/homework_12/task_2/" + fileName + ".txt");
            FileWriter fw = new FileWriter(file, true);
            fw.write(line + "\n");
            fw.close();
        }
        lnr.close();
    }

}