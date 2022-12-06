package Patterns.Structural.Decorator;

public class TruckCarImpl implements Car {

    private Car car;

    public TruckCarImpl(Car car) {
        this.car = car;
    }

    @Override
    public int getSpeed() {
        return this.car.getSpeed();
    }

    @Override
    public int getBaggageWeight() {
        System.out.println("New baggage weight is:");
        return this.car.getBaggageWeight()+1000;
    }

}
