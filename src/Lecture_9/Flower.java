package Lecture_9;

public abstract class Flower {
    protected String country;
    protected int numberOfDays;
    protected int price;
    protected static int count;

    public Flower(String country, int numberOfDays, int price) {
        this.country = country;
        this.numberOfDays = numberOfDays;
        this.price = price;
        count++;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Flower.count = count;
    }
}
