package Homework_6.ATM;

public class Calculations {
    public static void main(String[] args) {
        ATM atm = new ATM(16, 8, 10);
        System.out.println("Initial status of " + atm);
        atm.addMoneyOnlyTwenties(2);
        atm.addMoneyOnlyFifties(15);
        atm.addMoneyOnlyHundreds(14);
        atm.addDifferentCurrencies(20, 40, 18);
        System.out.println("--------------------------");
        System.out.println("After adding money " + atm);
        System.out.println("--------------------------");
        System.out.println("Was operation successful: " + atm.getMoney(6090));
        System.out.println("After issuing money " + atm);
    }
}
