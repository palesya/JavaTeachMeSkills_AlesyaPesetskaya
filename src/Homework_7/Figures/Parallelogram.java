package Homework_7.Figures;

public class Parallelogram extends Figure {

    private double height;
    private double baseSide;
    private double side;



    public Parallelogram(double height, double baseSide, double side) {
        this.height = height;
        this.baseSide = baseSide;
        this.side = side;
    }

    @Override
    public double countPerimeter() {
        return (this.baseSide+this.side)*2;
    }

    @Override
    protected double countSquare() {
        return this.height * this.baseSide;
    }
}
