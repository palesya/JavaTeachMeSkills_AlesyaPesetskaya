package homework_7.Figures;

public class Circle extends Figure{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    protected double countSquare() {
        return Math.pow(this.radius,2)*Math.PI;
    }

    @Override
    protected double countPerimeter() {
        return 2*this.radius*Math.PI;
    }
}
