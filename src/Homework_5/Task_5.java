package Homework_5;

import java.util.Arrays;

import static BaseMethodsForTwoDimArrays.BaseMethods.*;

public class Task_5 {
    public static void main(String[] args) {
        int[][] arr = generateSquareArray();
        printTwoDimArray(arr);
        printDiagonal(arr);
    }

    private static void printDiagonal( int[][] arr){
        int [] diagonalElements = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
                diagonalElements[i]=arr[i][i];
        System.out.println("Diagonal's elements are:"+ Arrays.toString(diagonalElements));
    }
}
