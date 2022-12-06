package Patterns.Structural.Decorator;

public class SimpleCarImpl implements Car {

    private int speed;
    private int baggageWeight;

    public SimpleCarImpl(int speed, int baggageWeight) {
        this.speed = speed;
        this.baggageWeight = baggageWeight;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public int getBaggageWeight() {
        return this.baggageWeight;
    }

    @Override
    public String toString() {
        return "SimpleCarImpl{" +
                "speed=" + speed +
                ", baggageWeight=" + baggageWeight +
                '}';
    }
}
