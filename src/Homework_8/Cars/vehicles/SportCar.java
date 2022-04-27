package Homework_8.Cars.vehicles;

import Homework_8.Cars.details.Engine;
import Homework_8.Cars.professions.Driver;

public class SportCar extends Car{

    private int maxSpeed;

    public SportCar(String brand, String classOfCar, int weight, Driver driver, Engine engine, int maxSpeed) {
        super(brand, classOfCar, weight, driver, engine);
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "\nIt is a sport car with max speed = " + maxSpeed+super.toString();
    }
}
