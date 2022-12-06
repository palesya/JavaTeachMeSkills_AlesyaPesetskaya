package Patterns.Structural.Adapter;

public class IceRoadAdapter implements Road{

    private IceRoad iceRoad;

    public IceRoadAdapter(IceRoad iceRoad) {
        this.iceRoad = iceRoad;
    }

    @Override
    public void run() {
        iceRoad.walk();
    }
}
