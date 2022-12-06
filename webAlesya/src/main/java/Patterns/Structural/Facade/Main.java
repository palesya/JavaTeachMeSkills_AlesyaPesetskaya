package Patterns.Structural.Facade;

public class Main {
    public static void main(String[] args) {

        OrderFacade order = new OrderFacade(new Product(),new Payment(),new Delivery());
        order.makeOrder();
        order.cancelOrder();

    }
}
