package Patterns.Creational.Factory;

public class WhiteBreadImpl implements Bread {
    @Override
    public void bake() {
        System.out.println("White bread produced.");
    }
}
