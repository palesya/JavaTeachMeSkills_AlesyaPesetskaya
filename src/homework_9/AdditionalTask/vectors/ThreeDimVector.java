package homework_9.AdditionalTask.vectors;

import homework_9.AdditionalTask.Vector;

import java.util.Arrays;

public class ThreeDimVector extends Vector {
    private static final int size = 3;
    private static final String description = "This is three dim vector";

    public ThreeDimVector(int[] coordinates) {
        super(coordinates);
        if (coordinates.length != size) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("This is not a three dim vector. It will be replaced by {0,0,0}.");
            this.coordinates = new int[size];
        }
    }

    public void getVectorInfo(){
        System.out.println("-------------------");
        System.out.println(description);
        System.out.printf("with coordinates %s", Arrays.toString(this.getCoordinates()));
        System.out.println("");
    }
}
