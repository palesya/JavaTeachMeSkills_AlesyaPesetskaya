package Patterns.Structural.Adapter;

public class RoadRunner {

    public static void main(String[] args) {

        Runner runnerIce = new Runner(new IceRoadAdapter(new IceRoad()));
        Runner runnerSimple = new Runner(new SimpleRoad());
        runnerIce.runOnTheRoad();
        runnerSimple.runOnTheRoad();

    }
}
