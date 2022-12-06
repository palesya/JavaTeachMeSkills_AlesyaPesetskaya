package Patterns.Structural.Decorator;

public class SportCarImpl implements Car {

    private Car car;

    public SportCarImpl(Car car) {
        this.car = car;
    }

    @Override
    public int getSpeed() {
        System.out.println("New speed is:");
        return this.car.getSpeed()+100;
    }

    @Override
    public int getBaggageWeight() {
        return this.car.getBaggageWeight();
    }

}
