package Homework_5;

import static BaseMethodsForTwoDimArrays.BaseMethods.printTwoDimArray;

public class Task3 {
    public static void main(String[] args) {
        int[][] firstArray = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}};
        int[][] secondArray = {{1, 2, 3}, {1, 1, 1}, {0, 0, 0}, {2, 1, 0}};
        int[][] resultArray = multiplicateMatrix(firstArray, secondArray);
        printTwoDimArray(resultArray);
        printInOneLine(resultArray);
    }

    private static int[][] multiplicateMatrix(int[][] arr1, int[][] arr2) {
        int[][] resultArray = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    resultArray[i][j] = resultArray[i][j] + arr1[i][k] * arr2[k][j];
                }
            }
        }
        return resultArray;
    }

    public static void printInOneLine(int[][] arr) {
        System.out.println("---------------------------------");
        System.out.println("Two-dimension array in one line: ");
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
        }
    }
}
