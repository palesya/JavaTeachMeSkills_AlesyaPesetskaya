package Patterns.Creational.AbstractFactory;

import Patterns.Creational.AbstractFactory.factory.CarFactory;

public class CarService {

    private final CarFactory factory;

    public CarService(CarFactory factory) {
        this.factory = factory;
    }

    public void doCar(){
        factory.createCircle();
        factory.createEngine();
    }
}
