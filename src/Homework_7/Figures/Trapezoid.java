package Homework_7.Figures;

public class Trapezoid extends Figure{

    private double height;
    private double baseSide;
    private double side1;
    private double side2;
    private double upperSide;

    public Trapezoid(double height, double baseSide, double side1, double side2, double upperSide) {
        this.height = height;
        this.baseSide = baseSide;
        this.side1 = side1;
        this.side2 = side2;
        this.upperSide = upperSide;
    }

    @Override
    protected double countSquare() {
       return (this.upperSide+this.baseSide)*this.height/2;
    }

    @Override
    protected double countPerimeter() {
        return this.upperSide+this.baseSide+this.side1+this.side2;
    }
}
