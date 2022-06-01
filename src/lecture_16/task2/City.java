package lecture_16.task2;

public class City {
    private String name;
    private Street street;

    public City(String name, Street street) {
        this.name = name;
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public Street getStreet() {
        return street;
    }
}
