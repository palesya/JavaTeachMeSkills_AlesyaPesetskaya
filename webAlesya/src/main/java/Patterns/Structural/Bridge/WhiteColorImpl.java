package Patterns.Structural.Bridge;

public class WhiteColorImpl implements Color {
    @Override
    public void setColor() {
        System.out.println("Color is white");
    }
}
