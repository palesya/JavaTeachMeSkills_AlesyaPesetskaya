package homework_20.entity;

public class Chocolate {

    private Integer id;
    private String name;
    private Chocolate.Brand brand;
    private int weight;

    public enum Brand{
        MARS,
        NESTLE,
        MILKA
    }

    public Chocolate(Integer id, String name, Brand brand, int weight) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.weight = weight;
    }

    public Chocolate(String name, Brand brand, int weight) {
        this.name = name;
        this.brand = brand;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Chocolate " +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", brand = " + brand +
                ", weight = " + weight;
    }
}
