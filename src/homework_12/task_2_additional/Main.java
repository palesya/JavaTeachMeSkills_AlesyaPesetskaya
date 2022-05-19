package homework_12.task_2_additional;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        SplitterService splitterService = new SplitterService();
        splitterService.splitTextToRoles("src/homework_12/task_2_additional/RomeoAndJuliet.txt");
    }
}
