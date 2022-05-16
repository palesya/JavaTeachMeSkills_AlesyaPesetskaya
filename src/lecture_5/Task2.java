package lecture_5;

import java.util.Arrays;

import static baseMethodsForTwoDimArrays.BaseMethods.generateTwoDimArray;
import static baseMethodsForTwoDimArrays.BaseMethods.printTwoDimArray;

public class Task2 {
    public static void main(String[] args) {
        int[][] arr = generateTwoDimArray();
        printTwoDimArray(arr);
        System.out.println("Max index = " + findIndexOfMaxLine(arr));
    }

    private static int findIndexOfMaxLine(int[][] arr) {
        int[] multiplication = new int[arr.length];
        int maxValue = 0;
        int maxIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            multiplication[i] = 1;
            for (int j = 0; j < arr[i].length; j++) {
                multiplication[i] = Math.abs(multiplication[i] * arr[i][j]);
            }
        }
        System.out.println("Multiplication array: ");
        System.out.println(Arrays.toString(multiplication));
        for (int i = 0; i < multiplication.length; i++) {
            if (multiplication[i] > maxValue) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
