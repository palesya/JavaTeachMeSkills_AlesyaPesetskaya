package lecture_6;

import static baseMethodsForTwoDimArrays.BaseMethods.printTwoDimArray;

public class Task {
    public static void main(String[] args) {
        Vector vector = new Vector(3, 4, 5);
        Vector vector1 = new Vector(1, 6, 8);
        System.out.println("Vector's length is: " + vector.countVectorLength());
        System.out.println("Vector's scalar product is: " + vector.countScalarProduct(vector1));
        System.out.println("Generated " + vector.countVectorProduct(vector1));
        System.out.println("Cosine = " + vector.countCos(vector1));
        System.out.println("Vector of sum " + vector.countSum(vector1));
        System.out.println("Vector of difference " + vector.countDifference(vector1));
        printTwoDimArray(vector.generateVectors());
    }
}
