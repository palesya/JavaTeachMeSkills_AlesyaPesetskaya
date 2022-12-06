package Patterns.Structural.Bridge;

public class SquareShapeImpl extends Shape {

    public SquareShapeImpl(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("This is square");
        color.setColor();
    }
}
