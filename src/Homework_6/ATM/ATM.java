package Homework_6.ATM;

public class ATM {
    private int numberOfTwenties;
    private int numberOfFifties;
    private int numberOfHundreds;

    public ATM(int numberOfTwenties, int numberOfFifties, int numberOfHundreds) {
        this.numberOfTwenties = numberOfTwenties;
        this.numberOfFifties = numberOfFifties;
        this.numberOfHundreds = numberOfHundreds;
    }

    public void addMoneyOnlyTwenties(int numberOfTwenties) {
        this.numberOfTwenties += numberOfTwenties;
    }

    public void addMoneyOnlyFifties(int numberOfFifties) {
        this.numberOfFifties += numberOfFifties;
    }

    public void addMoneyOnlyHundreds(int numberOfHundreds) {
        this.numberOfHundreds += numberOfHundreds;
    }

    public void addDifferentCurrencies(int numberOfTwenties, int numberOfFifties, int numberOfHundreds) {
        this.numberOfTwenties += numberOfTwenties;
        this.numberOfFifties += numberOfFifties;
        this.numberOfHundreds += numberOfHundreds;
    }

    public boolean getMoney(int sum) {
        boolean isSuccessful = false;
        int totalAmountOfMoney = this.numberOfTwenties * 20 + this.numberOfFifties * 50 + numberOfHundreds * 100;
        int remainingSum = -1;
        int numberOfIssuedHundreds = 0;
        int numberOfIssuedFifties = 0;
        int numberOfIssuedTwenties = 0;
        if (sum > totalAmountOfMoney) {
            System.out.println("Such amount " + sum + " can't be issued. Available amount is " + totalAmountOfMoney);
        } else if (sum % 10 == 0 && sum >= 20 && sum != 30) {
            remainingSum = sum;
            numberOfIssuedHundreds = Math.abs(remainingSum / 100);
            if (numberOfIssuedHundreds > this.numberOfHundreds) {
                numberOfIssuedHundreds = this.numberOfHundreds;
            }
            remainingSum -= numberOfIssuedHundreds * 100;
            numberOfIssuedFifties = Math.abs(remainingSum / 50);
            if (numberOfIssuedFifties > this.numberOfFifties) {
                numberOfIssuedFifties = this.numberOfFifties;
            }
            remainingSum -= numberOfIssuedFifties * 50;
            if (remainingSum == 10 || remainingSum == 30) {
                numberOfIssuedFifties--;
                remainingSum += 50;
            }
            numberOfIssuedTwenties = Math.abs(remainingSum / 20);
            if (numberOfIssuedTwenties > this.numberOfTwenties) {
                numberOfIssuedTwenties = this.numberOfTwenties;
            }
            remainingSum -= numberOfIssuedTwenties * 20;
            if(remainingSum != 0) {
                System.out.println("Such amount " + sum + " can't be issued with given in ATM 20, 50 and 100 notes.");
            }
        }else{
            System.out.println("Such amount " + sum + " can't be issued with given in ATM 20, 50 and 100 notes.");
        }
        if (remainingSum == 0) {
            System.out.println("Number of issued hundreds = " + numberOfIssuedHundreds);
            this.numberOfHundreds -= numberOfIssuedHundreds;
            System.out.println("Number of issued fifties = " + numberOfIssuedFifties);
            this.numberOfFifties -= numberOfIssuedFifties;
            System.out.println("Number of issued twenties = " + numberOfIssuedTwenties);
            this.numberOfTwenties -= numberOfIssuedTwenties;
            isSuccessful = true;
        }
        return isSuccessful;
    }

    @Override
    public String toString() {
        return "ATM with currencies: " +
                "number of 20s = " + numberOfTwenties +
                ", number of 50s = " + numberOfFifties +
                ", number of 100s = " + numberOfHundreds +
                '.';
    }
}

