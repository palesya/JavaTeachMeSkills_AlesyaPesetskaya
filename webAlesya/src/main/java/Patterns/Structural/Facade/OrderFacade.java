package Patterns.Structural.Facade;

public class OrderFacade {

    private Product product;
    private Payment payment;
    private Delivery delivery;

    public OrderFacade(Product product, Payment payment, Delivery delivery) {
        this.product = product;
        this.payment = payment;
        this.delivery = delivery;
    }

    public void makeOrder(){
        product.addProduct();
        payment.makePayment();
        payment.confirmPayment();
        delivery.arrangeDelivery();
        delivery.doDelivery();
    }

    public void cancelOrder(){
       product.removeProduct();
       payment.cancelPayment();
       delivery.cancelDelivery();
    }
}
