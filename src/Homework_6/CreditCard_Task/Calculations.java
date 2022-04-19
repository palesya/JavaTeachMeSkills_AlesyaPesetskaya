package Homework_6.CreditCard_Task;

public class Calculations {
    public static void main(String[] args) {
        CreditCard creditCard=new CreditCard();
        CreditCard[] creditCards=creditCard.generateThreeCardsViaScanner();
        creditCards[0].getCardInfo();
        creditCards[1].getCardInfo();
        creditCards[2].getCardInfo();
        creditCards[0].addSum();
        creditCards[1].addSum();
        creditCards[2].withdraw();
        System.out.println("Cards' data after changes:");
        creditCards[0].getCardInfo();
        creditCards[1].getCardInfo();
        creditCards[2].getCardInfo();
    }

}
