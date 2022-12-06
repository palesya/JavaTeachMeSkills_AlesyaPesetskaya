package Patterns.Creational.AbstractFactory;

import Patterns.Creational.AbstractFactory.factory.AudiFactoryImpl;
import Patterns.Creational.AbstractFactory.factory.CarFactory;
import Patterns.Creational.AbstractFactory.factory.VolvoFactoryImpl;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CarFactory factoryAudi = new AudiFactoryImpl();
        CarFactory factoryVolvo = new VolvoFactoryImpl();

        List<CarFactory> allFactories = Arrays.asList(factoryAudi,factoryVolvo);
        for(CarFactory factory:allFactories){
            CarService service = new CarService(factory);
            service.doCar();
        }
    }
}
