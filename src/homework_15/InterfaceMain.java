package homework_15;

import java.util.Scanner;

public class InterfaceMain {
    public static void main(String[] args) {

        String line = "Hello, world!";
        int value = 4;
        System.out.println("Enter 1 to get reversed line '"+line+"'\nor 2 to count factorial of number "+value);
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        MyService myService = new MyService();
        myService.process(input, line, value, (inp, l, v) -> {
            if (inp == 1) {
                String reversedLine = new StringBuilder(l).reverse().toString();
                System.out.println("Line was reversed to:\n" + reversedLine);
            } else if (inp == 2) {
                int result = factorial(v);
                System.out.println("Factorial of " + v + " is " + result);
            } else {
                System.out.println("Only 1 and 2 should be entered");
            }
        });
    }

    private static int factorial(int num) {
        if (num > 1) {
            return num * factorial(num - 1);
        } else {
            return 1;
        }
    }

}
