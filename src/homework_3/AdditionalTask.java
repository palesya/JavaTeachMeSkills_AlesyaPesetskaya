package homework_3;

import java.util.Scanner;

public class AdditionalTask {

    public static void main(String[] args) {
        getFirstElevenFibonacciNumbers();
        countDeposit();
        getMultiplicateTable();
    }

    public static void getFirstElevenFibonacciNumbers() {
        System.out.println("The first 11 terms of Fibonacci sequence:");
        int currentTerm;
        int prePreviousTerm = -1;
        int previousTerm = 1;
        for (int i = 0; i < 11; i++) {
            currentTerm = previousTerm + prePreviousTerm;
            prePreviousTerm = previousTerm;
            previousTerm = currentTerm;
            System.out.print((currentTerm) + " ");
        }
        System.out.println("");
        System.out.println("-----------------------------------------------------------");
    }

    public static void countDeposit() {
        Scanner scanner = new Scanner(System.in);
        boolean validDeposit = false;
        float initialAmount = 0;
        float currentDeposit;
        int numberOfMonths;
        while (!validDeposit) {
            System.out.println("Please enter the deposit amount (positive number).");
            if (!scanner.hasNextFloat()) {
                System.out.println("You've entered invalid value.");
                scanner.next();
            } else {
                initialAmount = scanner.nextFloat();
                if (initialAmount <= 0) {
                    System.out.println("You've entered invalid value.");
                } else {
                    validDeposit = true;
                }
            }
        }
        System.out.println("To know the number of months for deposit.");
        numberOfMonths=Cycles.checkWholePositiveNumber();
        currentDeposit = initialAmount;
        for (int i = 0; i < numberOfMonths; i++) {
            float percentage = currentDeposit * 7 / 100;
            currentDeposit = currentDeposit + percentage;
        }
        System.out.println("The total sum of your deposit from the initial amount of " + initialAmount);
        System.out.println("for the period of " + numberOfMonths + " months");
        System.out.println("equals " + currentDeposit);
        System.out.println("-----------------------------------------------------------");
    }

    public static void getMultiplicateTable() {
        System.out.println("Multiplicate Table:");
        for (int i = 1; i < 11; i++) {
            System.out.println("-----------");
            for (int j = 1; j < 11; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }
    }
}
