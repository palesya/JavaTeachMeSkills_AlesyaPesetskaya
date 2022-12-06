package Patterns.Structural.Adapter;

public class SimpleRoad implements Road{
    @Override
    public void run() {
        System.out.println("You run on a simple road");
    }
}
