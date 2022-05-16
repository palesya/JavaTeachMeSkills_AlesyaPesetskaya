package homework_9.AdditionalTask.vectors;

import homework_9.AdditionalTask.Vector;

import java.util.Arrays;

public class TwoDimVector extends Vector {

    private static final int size = 2;
    private static final String description = "This is two dim vector";

    public TwoDimVector(int[] coordinates) {
        super(coordinates);
        if (coordinates.length != size) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("This is not a two dim vector. It will be replaced by {0,0}.");
            this.coordinates=new int[size];
        }
    }

    public void getVectorInfo(){
        System.out.println("-------------------");
        System.out.println(description);
        System.out.printf("with coordinates %s", Arrays.toString(this.getCoordinates()));
        System.out.println("");
    }

    @Override
    public String toString() {
        return "TwoDimVector{" +
                "coordinates=" + Arrays.toString(coordinates) +
                '}';
    }
}
