package homework_2;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name:");
        String user = scanner.next();
        System.out.println("Hello, " + user + "!");
    }
}
