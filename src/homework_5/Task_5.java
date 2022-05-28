package homework_5;

import java.util.Arrays;

import static baseMethodsForTwoDimArrays.BaseMethods.*;

public class Task_5 {
    public static void main(String[] args) {
        int[][] arr = generateSquareArray();
        printTwoDimArray(arr);
        printMainDiagonal(arr);
        printSecondaryDiagonal(arr);
    }

    private static void printMainDiagonal(int[][] arr) {
        int[] diagonalElements = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            diagonalElements[i] = arr[i][i];
        System.out.println("MainMap diagonal's elements are:" + Arrays.toString(diagonalElements));
    }

    private static void printSecondaryDiagonal(int[][] arr) {
        int[] diagonalElements = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--){
                diagonalElements[arr.length-1-i] = arr[i][arr.length-1-i];
            }
        System.out.println("Secondary diagonal's elements are:" + Arrays.toString(diagonalElements));
    }
}
