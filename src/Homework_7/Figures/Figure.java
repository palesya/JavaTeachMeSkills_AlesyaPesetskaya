package Homework_7.Figures;

public abstract class Figure {

    protected abstract double countSquare();

    protected abstract double countPerimeter();

    protected double countRibLength(double[]allLength){
        double sumOfRibLength=0;
        for (double v : allLength) {
            sumOfRibLength +=v;
        }
        return sumOfRibLength;
    }

}
