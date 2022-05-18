package homework_11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInputRepository userInputRepository = new UserInputRepository();
        System.out.println("Welcome to 'User Repository' program!");
        Scanner scanner = new Scanner(System.in);
        printMenu();
        UserInputValidationService validationService = new UserInputValidationService();
        String input = scanner.nextLine();
        while (validationService.validateInput(input, userInputRepository)) {
            if(validationService.ifMenuPrint){
            printMenu();}
            input = scanner.next();
        }
    }

    private static void printMenu() {
        System.out.println("Menu: \n1. Enter any string value and press Enter to save in repository;" +
                "\n2. Enter 'get' to see the first value from repository and to delete it;" +
                "\n3. Enter 'exit' to finish program running;");
    }
}
