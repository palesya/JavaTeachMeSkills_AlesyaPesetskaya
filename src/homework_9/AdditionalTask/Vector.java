package homework_9.AdditionalTask;

import java.util.Arrays;

public abstract class Vector {

    protected int[] coordinates;

    public Vector(int[] coordinates) {
        this.coordinates = coordinates;
    }

    protected void countVectorLength() {
        System.out.println("");
        int sum = 0;
        for (int el : coordinates) {
            sum += Math.pow(el, 2);
        }
        System.out.printf("Vector's length = %.2f", Math.sqrt(sum));
    }

    protected void countScalarMultiply(Vector vector) {
        int sum = 0;
        for (int i = 0; i < coordinates.length; i++) {
            sum += this.getCoordinates()[i] * vector.getCoordinates()[i];
        }
        System.out.println("");
        System.out.printf("Scalar multiplication = %d", sum);
    }

    protected void sumVectors(Vector vector) {
        int length = this.coordinates.length;
        int[] coord = new int[length];
        for (int i = 0; i < length; i++) {
            coord[i] = this.getCoordinates()[i] + vector.getCoordinates()[i];
        }
        System.out.println("Vectors' sum is a vector with coordinates = "+ Arrays.toString(coord));
    }

    protected void minusVectors(Vector vector) {
        int length = this.coordinates.length;
        int[] coord = new int[length];
        for (int i = 0; i < length; i++) {
            coord[i] = this.getCoordinates()[i] - vector.getCoordinates()[i];
        }
        System.out.println("Vectors' subtraction is a vector with coordinates = "+ Arrays.toString(coord));
    }

    protected void compareVectors(Vector vector) {
        int length = this.coordinates.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (this.getCoordinates()[i] != vector.getCoordinates()[i]
                    || this.getCoordinates().length != vector.getCoordinates().length) {
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println("Vectors with coordinates "+ Arrays.toString(this.getCoordinates())+" and " +Arrays.toString(vector.getCoordinates())+" are equal");
        } else {
            System.out.println("Vectors with coordinates "+ Arrays.toString(this.getCoordinates())+" and " +Arrays.toString(vector.getCoordinates())+" are not equal");
        }
    }

    protected abstract void getVectorInfo();

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "vector with coordinates = " + Arrays.toString(coordinates);
    }
}
