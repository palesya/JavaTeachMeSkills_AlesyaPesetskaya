package lecture_6;

import java.util.Random;

import static baseMethodsForOneDimArrays.BaseMethods.checkWholeNumber;

public class Vector {
    private int x;
    private int y;
    private int z;

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double countVectorLength() {
        return Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2));
    }

    public int countScalarProduct(Vector vector) {
        return this.getX() * vector.getX() + this.getY() * vector.getY() + this.getZ() * vector.getZ();
    }

    public Vector countVectorProduct(Vector vector) {
        int a = this.getY() * vector.getZ() - this.getZ() * vector.getY();
        int b = this.getZ() * vector.getX() - this.getX() * vector.getZ();
        int c = this.getX() * vector.getY() - this.getY() * vector.getX();
        return new Vector(a, b, c);
    }

    public double countCos(Vector vector) {
        return countScalarProduct(vector) / (Math.abs(vector.countVectorLength()) * Math.abs(this.countVectorLength()));
    }

    public Vector countSum(Vector vector) {
        int a = this.getX() + vector.getX();
        int b = this.getY() + vector.getY();
        int c = this.getZ() + vector.getZ();
        return new Vector(a, b, c);
    }

    public Vector countDifference(Vector vector) {
        int a = this.getX() - vector.getX();
        int b = this.getY() - vector.getY();
        int c = this.getZ() - vector.getZ();
        return new Vector(a, b, c);
    }

    public int[][] generateVectors() {
        System.out.println("--------------------------------");
        System.out.println("Enter number of vectors.");
        int numberOfLines = checkWholeNumber();
        int[][] arr = new int[numberOfLines][3];
        for (int i = 0; i < numberOfLines; i++) {
            for (int j = 0; j < 3; j++) {
                Random random = new Random();
                arr[i][j] = random.nextInt(99);
            }
        }
        return arr;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Vector {" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
