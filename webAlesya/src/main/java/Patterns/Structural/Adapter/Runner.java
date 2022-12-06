package Patterns.Structural.Adapter;

public class Runner {

    private Road road;

    public Runner(Road road) {
        this.road = road;
    }

    public void runOnTheRoad(){
        System.out.println("Let's run");
        road.run();
        System.out.println("Finish");
    }
}
