package Homework_6.CreditCard_Task;

public class CreditCard {
    private String accountNumber;
    private double currentSum;

    public CreditCard(String accountNumber, double currentSum) {
        this.accountNumber = accountNumber;
        this.currentSum = currentSum;
    }

    public void addSumToCard(double sum) {
        checkSumIsPositive(sum);
        currentSum = this.currentSum + sum;
    }

    public void withdrawSumFromCard(double sum) {
        checkSumIsPositive(sum);
        if (this.currentSum < sum) {
            System.out.printf("Operation is impossible for card '%s'. Available sum is %.2f",this.accountNumber,this.currentSum);
            System.out.println();
        } else {
            currentSum = this.currentSum - sum;
        }
    }

    public void getCardInfo() {
        System.out.println("Card's number is '" + this.getAccountNumber() + "' and current sum is " + this.getCurrentSum());
    }

    private void checkSumIsPositive(double sum) {
        if (sum < 0) {
            System.out.println("Please check sum you've entered. It is negative.");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getCurrentSum() {
        return currentSum;
    }
}
