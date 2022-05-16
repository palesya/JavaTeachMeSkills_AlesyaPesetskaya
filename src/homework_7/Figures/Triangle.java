package homework_7.Figures;

public class Triangle extends Figure{

    private double baseSide;
    private double side1;
    private double side2;

    public Triangle(double baseSide, double side1,double side2) {
        this.baseSide = baseSide;
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    protected double countSquare() {
        double halfPerimeter=this.countPerimeter()/2;
        return Math.sqrt(halfPerimeter*(halfPerimeter-baseSide)*(halfPerimeter-side1)*(halfPerimeter-side2));
    }

    @Override
    protected double countPerimeter() {
        return baseSide+side1+side2;
    }

}
