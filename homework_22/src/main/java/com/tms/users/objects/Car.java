package com.tms.users.objects;

public class Car {

    private String brand;
    private String year;
    private String color;

    public Car(String brand, String year, String color) {
        this.brand = brand;
        this.year = year;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "brand = " + brand +
                ", year = " + year +
                ", color = " + color;
    }
}
