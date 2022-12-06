package Patterns.Creational.Factory;

public class Main {

    public static void main(String[] args) {

        BreadFactory factory = new BreadFactory();

        Bread bread = factory.produceBread(BreadTypes.DARK);
        Bread bread1 = factory.produceBread(BreadTypes.WHITE);
        Bread bread2 = factory.produceBread(null);
        bread.bake();
        bread1.bake();
        bread2.bake();

    }
}
