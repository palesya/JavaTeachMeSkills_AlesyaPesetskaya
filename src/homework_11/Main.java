package homework_11;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInputRepository userInputRepository = new UserInputRepository();
        System.out.println("Welcome to 'User Repository' program!");
        Scanner scanner = new Scanner(System.in);
        printMenu();
        UserInputCheckService validationService = new UserInputCheckService(userInputRepository);
        String input = scanner.nextLine();
        while (!Objects.equals(input, "exit")) {
            if (validationService.validateInput(input))
            {
                printMenu();
            }
            input = scanner.next();
        }
    }

    private static void printMenu() {
        System.out.println("Menu: \n1. Enter any string value and press Enter to save in repository;" +
                "\n2. Enter 'get' to see the first value from repository and to delete it;" +
                "\n3. Enter 'exit' to finish program running;");
    }
}
