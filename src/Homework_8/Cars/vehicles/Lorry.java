package Homework_8.Cars.vehicles;

import Homework_8.Cars.details.Engine;
import Homework_8.Cars.professions.Driver;

public class Lorry extends Car{

    private int capacity;

    public Lorry(String brand, String classOfCar, int weight, Driver driver, Engine engine,int capacity) {
        super(brand, classOfCar, weight, driver, engine);
        this.capacity=capacity;
    }

    @Override
    public String toString() {
        return "\nIt is a Lorry with capacity = " + capacity+super.toString();
    }
}
