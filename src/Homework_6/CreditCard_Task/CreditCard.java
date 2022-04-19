package Homework_6.CreditCard_Task;

import java.util.Objects;
import java.util.Scanner;

public class CreditCard {
    private String accountNumber;
    private double currentSum;

    Scanner scanner = new Scanner(System.in);

    public CreditCard() {
    }

    public CreditCard(String accountNumber, double currentSum) {
        this.accountNumber = accountNumber;
        this.currentSum = currentSum;
    }

    public void addSum() {
        System.out.println("---------------------");
        System.out.println("What sum do you want to add to card '" + this.getAccountNumber() + "'?");
        double sum = checkSumIsPositive();
        currentSum = this.currentSum + sum;
    }

    public void withdraw() {
        System.out.println("---------------------");
        double sum = 0;
        boolean validValue = false;
        while (!validValue) {
            System.out.println("What sum do you want to take from card '" + this.getAccountNumber() + "'?");
            sum = checkSumIsPositive();
            if (sum > this.getCurrentSum()) {
                System.out.println("There are not enough funds in the account. Please check taking sum.");
            } else {
                validValue = true;
            }
        }
        currentSum = this.currentSum - sum;
    }

    public void getCardInfo() {
        System.out.println("Card's number is '" + this.getAccountNumber() + "' and current sum is " + this.getCurrentSum());
    }

    public CreditCard[] generateThreeCardsViaScanner() {
        CreditCard[] creditCard = new CreditCard[3];
        System.out.println("--------------------------------");
        for (int i = 0; i < 3; i++) {
            Scanner scanner = new Scanner(System.in);
            boolean isUniqueValue = false;
            while (!isUniqueValue) {
                System.out.println("Enter account's number for the " + getCardsNumber(i) + " card.");
                this.accountNumber = scanner.nextLine();
                if (i == 1 && Objects.equals(creditCard[i - 1].getAccountNumber(), this.accountNumber)) {
                    System.out.println("Such account's number already exists.");
                } else if (i == 2 && (Objects.equals(creditCard[i - 1].getAccountNumber(), this.accountNumber)||Objects.equals(creditCard[i - 2].getAccountNumber(), this.accountNumber))) {
                    System.out.println("Such account's number already exists.");
                } else {
                    isUniqueValue = true;
                }
            }
            System.out.println("Enter current sum for the " + getCardsNumber(i) + " card.");
            this.currentSum = checkSumIsPositive();
            creditCard[i] = new CreditCard(this.accountNumber, this.currentSum);
        }
        return creditCard;
    }

    private double checkSumIsPositive() {
        double sum = 0;
        boolean validValue = false;
        while (!validValue) {
            System.out.println("Please enter positive number.");
            if (!scanner.hasNextDouble()) {
                System.out.println("You've entered invalid value.");
                scanner.next();
            } else {
                sum = scanner.nextDouble();
                if (sum > 0) {
                    validValue = true;

                } else {
                    System.out.println("You've entered invalid value.");
                }
            }
        }
        return sum;
    }

    private String getCardsNumber(int number) {
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getCurrentSum() {
        return currentSum;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCurrentSum(double currentSum) {
        this.currentSum = currentSum;
    }

}
