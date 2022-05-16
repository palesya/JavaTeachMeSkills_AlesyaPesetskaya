package lecture_6;

public class Product {
    private String name;
    private int price;
    private int tax;

    public Product() {

    }

    public Product(String name) {
        this.name = name;
    }

    public Product(int price) {
        this.price = price;
    }

    public Product(String name, int price) {
        this(name);
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getTax() {
        return tax;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTax(int... k) {
        for (int i:k) {
            this.tax += i;
        }
    }

    public void setTax(int tax,int k) {
        this.tax = tax*k;
    }

    public void setTax(String country) {
        switch (country) {
            case "RU":
                this.tax = 10;
                break;
            case "USA":
                this.tax = 25;
                break;
            case "BEL":
                this.tax = 12;
                break;
            case "UAE":
                this.tax = 30;
                break;
            default:
                this.tax = 11;
                break;
        }
    }
}
