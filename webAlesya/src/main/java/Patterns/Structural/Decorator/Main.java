package Patterns.Structural.Decorator;

public class Main {
    public static void main(String[] args) {

        Car simpleCar = new SimpleCarImpl(100, 1500);
        System.out.println(simpleCar);
        Car sportCar = new SportCarImpl(simpleCar);
        Car truckCar = new TruckCarImpl(simpleCar);
        System.out.println(sportCar.getSpeed());
        System.out.println(truckCar.getBaggageWeight());

    }
}
