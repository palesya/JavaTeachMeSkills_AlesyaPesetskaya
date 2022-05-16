package homework_7.Figures;

public class Rectangle extends Figure{

    private double side1;
    private double side2;

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    protected double countSquare() {
        return this.side1*this.side2;
    }

    @Override
    protected double countPerimeter() {
        return (side1+side2)*2;
    }
}
