package Patterns.Structural.Composite;

public class Item implements Product {

    private Integer price;
    private String name;

    public Item(Integer price, String name) {
        this.price = price;
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer countPrice() {
        return price;
    }
}
