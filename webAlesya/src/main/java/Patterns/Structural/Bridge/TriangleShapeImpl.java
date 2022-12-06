package Patterns.Structural.Bridge;

public class TriangleShapeImpl extends Shape {

    public TriangleShapeImpl(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("This is triangle");
        color.setColor();
    }
}
