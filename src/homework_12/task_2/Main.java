package homework_12.task_2;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        SplitterService splitterService = new SplitterService();
        splitterService.splitTextByRoles("src/homework_12/task_2/RomeoAndJuliet.txt");
    }
}
