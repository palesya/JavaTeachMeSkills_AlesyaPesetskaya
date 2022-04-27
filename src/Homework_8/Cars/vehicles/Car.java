package Homework_8.Cars.vehicles;

import Homework_8.Cars.details.Engine;
import Homework_8.Cars.professions.Driver;

public class Car {
    protected String brand;
    protected String classOfCar;
    protected int weight;
    protected Driver driver;
    protected Engine engine;

    public Car(String brand, String classOfCar, int weight, Driver driver, Engine engine) {
        this.brand = brand;
        this.classOfCar = classOfCar;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
    }

    public Car(String brand, String classOfCar, int weight) {
        this.brand = brand;
        this.classOfCar = classOfCar;
        this.weight = weight;
        this.driver = new Driver();
        this.engine = new Engine();
    }

    protected void start(){
        System.out.println("Let's go!");
    }
    protected void stop(){
        System.out.println("Stop!");
    }
    protected void turnRight(){
        System.out.println("Turn right.");
    }
    protected void turnLeft(){
        System.out.println("Turn left.");
    }

    @Override
    public String toString() {
        return "\nCar's common  information:" +
                "\nbrand: " + brand +
                "\nclassOfCar: " + classOfCar+
                "\nweight= " + weight +
                "\ndriver is " +this.driver.getName()+ " with years of practice = " +this.driver.getYearsOfPractice() +
                "\nengine's manufacturer is " + this.engine.getManufacturer()+" and engine's power is "+this.engine.getPower();
    }
}
