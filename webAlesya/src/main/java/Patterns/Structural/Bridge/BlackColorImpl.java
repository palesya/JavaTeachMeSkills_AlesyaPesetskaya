package Patterns.Structural.Bridge;

public class BlackColorImpl implements Color {
    @Override
    public void setColor() {
        System.out.println("Color is black");
    }
}
