import net.minidev.json.parser.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static JSONObject parseJSONFile() throws JSONException, IOException {
        String content = new String(Files.readAllBytes(Path.of("D:/JavaTeachMeSkills_AlesyaPesetskaya/untitled/src/data.json")));
        return new JSONObject(content);
    }

    public static void main(String[] args) throws IOException, JSONException, ParseException {

        JSONObject jsonObject = parseJSONFile();
        float weightFloat = (float) jsonObject.getDouble("weight");
        int weightInt;
        if (weightFloat % 1 == 0) {
            weightInt = (int) weightFloat;
            jsonObject.put("weight", weightInt);
        }
        String s = jsonObject.toString();

        System.out.println(s);

    }
}

