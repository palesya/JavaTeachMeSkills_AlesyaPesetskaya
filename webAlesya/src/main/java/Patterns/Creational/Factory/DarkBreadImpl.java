package Patterns.Creational.Factory;

public class DarkBreadImpl implements Bread {
    @Override
    public void bake() {
        System.out.println("Dark bread produced.");
    }
}
