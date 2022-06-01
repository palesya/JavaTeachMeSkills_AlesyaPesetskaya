package lecture_16.task2;

public class Country {
    private String name;
    private City city;

    public Country(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", city=" + city +
                '}';
    }
}
