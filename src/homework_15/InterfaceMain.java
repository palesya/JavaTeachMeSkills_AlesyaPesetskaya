package homework_15;

import java.util.Scanner;

public class InterfaceMain {
    public static void main(String[] args) {

        String line = "Hello, world!";
        int value = 4;

        InterfaceHelper helper = new InterfaceHelper();

        System.out.println("Enter 1 to get reversed line '" + line + "'\nor 2 to count factorial of number " + value);
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        MyService myService = new MyService();
        if (input == 1) {
            myService.convertLine(input, line, (i, l) -> helper.printConvertedLine(l));
        } else if (input == 2) {
            myService.countFactorial(input, value, (i, l) -> helper.printFactorial(l));
        } else {
            System.out.println("Only 1 and 2 should be entered");
        }
    }



}
