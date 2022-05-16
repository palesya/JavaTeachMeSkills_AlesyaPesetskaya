package homework_3;

import java.util.Scanner;

public class Cycles {

    public static void main(String[] args) {
        getNotEvenNumbers();
        getNumbersFrom5To1();
        countSum();
        getSequenceWithStepSeven();
        getSequenceWithStepMinusFive();
        getSequenceWithSquaresOfNumbers();
    }

    public static void getNotEvenNumbers() {
        System.out.println("The sequence of not even numbers from 1 to 99:");
        for (int i = 1; i < 100; i++) {
            System.out.print((i++) + " ");
        }
        System.out.println("");
        System.out.println("-----------------------------------------------------------");
    }

    public static void getNumbersFrom5To1() {
        System.out.println("The sequence of numbers from 5 to 1:");
        for (int i = 5; i > 0; i--) {
            System.out.print((i) + " ");
        }
        System.out.println("");
        System.out.println("-----------------------------------------------------------");
    }

    public static void countSum() {
        int sum = 0;
        System.out.println("The sum of all numbers from 1 to entered number will be counted.");
        int number=checkWholePositiveNumber();
        for (int i = 0; i <= number; i++) {
            sum = sum + i;
        }
        System.out.println("Sum of all numbers from 1 to " + number + " is " + sum);
        System.out.println("-----------------------------------------------------------");
    }

    public static void getSequenceWithStepSeven() {
        System.out.println("The sequence of numbers from 7 to 98 with step 7:");
        int numberOfSequence = 0;
        while (numberOfSequence < 98) {
            numberOfSequence += 7;
            System.out.print((numberOfSequence) + " ");
        }
        System.out.println("");
        System.out.println("-----------------------------------------------------------");
    }

    public static void getSequenceWithStepMinusFive() {
        System.out.println("The sequence of first 10 numbers from 0 with step -5:");
        int numberOfSequence = 0;
        for (int i = 0; i < 10; i++) {
            System.out.print((numberOfSequence) + " ");
            numberOfSequence -= 5;
        }
        System.out.println("");
        System.out.println("-----------------------------------------------------------");
    }

    public static void getSequenceWithSquaresOfNumbers() {
        System.out.println("The sequence of squares of numbers from 10 to 20:");
        int squareOfNumber;
        for (int i = 10; i < 21; i++) {
            squareOfNumber = (int) Math.pow(i, 2);
            System.out.print((squareOfNumber) + " ");
        }
        System.out.println("");
        System.out.println("-----------------------------------------------------------");
    }

    public static int checkWholePositiveNumber(){
        Scanner scanner = new Scanner(System.in);
        boolean validValue=false;
        int number = 0;
        while (!validValue) {
            System.out.println("Please enter the whole positive number.");
            if (!scanner.hasNextInt()) {
                System.out.println("You've entered invalid value.");
                scanner.next();
            } else {
                number = scanner.nextInt();
                if (number <= 0) {
                    System.out.println("You've entered invalid value.");
                } else {
                    validValue = true;
                }
            }
        }
        return number;
    }
}
