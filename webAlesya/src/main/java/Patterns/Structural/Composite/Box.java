package Patterns.Structural.Composite;

import java.util.List;

public class Box implements Product {

    private Integer totalPrice = 0;
    private List<Product> components;

    public Box(List<Product> components) {
        this.components = components;
    }

    @Override
    public Integer countPrice() {
        for(Product product:components){
            totalPrice += product.countPrice();
        }
        return totalPrice;
    }
}
