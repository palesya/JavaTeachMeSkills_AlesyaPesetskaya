package homework_6.CreditCard_Task;

public class Calculations {
    public static void main(String[] args) {
        CreditCard[] creditCards=CardGenerator.generateThreeCardsViaScanner();
        creditCards[0].getCardInfo();
        creditCards[1].getCardInfo();
        creditCards[2].getCardInfo();
        creditCards[0].addSumToCard(300);
        creditCards[1].addSumToCard(400);
        creditCards[2].withdrawSumFromCard(500);
        System.out.println("-------------------------------");
        System.out.println("Cards' data after changes:");
        creditCards[0].getCardInfo();
        creditCards[1].getCardInfo();
        creditCards[2].getCardInfo();
    }



}
