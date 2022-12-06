package Patterns.Structural.Bridge;

public class Main {

    public static void main(String[] args) {

        Shape triangleWhite = new TriangleShapeImpl(new WhiteColorImpl());
        triangleWhite.draw();
        Shape squareBlack = new SquareShapeImpl(new BlackColorImpl());
        squareBlack.draw();

    }
}
