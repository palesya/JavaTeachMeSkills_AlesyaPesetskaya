package Homework_6.CreditCard_Task;


import BaseMethodsForOneDimArrays.BaseMethods;

import java.util.Objects;
import java.util.Scanner;

public class CardGenerator {
    public static CreditCard[] generateThreeCardsViaScanner() {
        String accountNumber = null;
        double currentSum;
        CreditCard[] creditCard = new CreditCard[3];
        System.out.println("--------------------------------");
        for (int i = 0; i < 3; i++) {
            Scanner scanner = new Scanner(System.in);
            boolean isUniqueValue = false;
            while (!isUniqueValue) {
                System.out.println("Enter account's number for the " + getCardsNumber(i) + " card.");
                accountNumber=scanner.nextLine();
                if (i == 1 && Objects.equals(creditCard[i - 1].getAccountNumber(), accountNumber)) {
                    System.out.println("Such account's number already exists.");
                } else if (i == 2 && (Objects.equals(creditCard[i - 1].getAccountNumber(), accountNumber)
                        || Objects.equals(creditCard[i - 2].getAccountNumber(), accountNumber)))
                {
                    System.out.println("Such account's number already exists.");
                } else{
                    isUniqueValue = true;
                }
            }
            System.out.println("Enter current sum for the " + getCardsNumber(i) + " card.");
            currentSum=BaseMethods.checkPositiveNumber();
            creditCard[i] = new CreditCard(accountNumber, currentSum);
        }
        return creditCard;
    }

    private static String getCardsNumber(int number) {
        String numberString = null;
        switch (number) {
            case 0:
                numberString = "first";
                break;
            case 1:
                numberString = "second";
                break;
            case 2:
                numberString = "third";
                break;
        }
        return numberString;
    }

}
