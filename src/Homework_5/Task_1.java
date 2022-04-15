package Homework_5;

import static BaseMethodsForOneDimArrays.BaseMethods.checkWholeNumber;

public class Task_1 {
    public static void main(String[] args) {
        int[][][] arr = generateThreeDimArray();
        printThreeDimArray(arr);
        increaseElementsOfThreeDimArray(arr);
        printThreeDimArray(arr);
    }

    private static int[][][] generateThreeDimArray() {
        System.out.println("--------------------------------");
        System.out.println("Enter first dimension for array.");
        int firstDim = checkWholeNumber();
        System.out.println("Enter second dimension for array.");
        int secondDim = checkWholeNumber();
        System.out.println("Enter third dimension for array.");
        int thirdDim = checkWholeNumber();
        System.out.println("Enter the max value of Array.");
        int maxValue = checkWholeNumber();
        int[][][] arr = new int[firstDim][secondDim][thirdDim];
        for (int i = 0; i < firstDim; i++) {
            for (int j = 0; j < secondDim; j++) {
                for (int k = 0; k < thirdDim; k++)
                    arr[i][j][k] = (int) (Math.random() * (maxValue + 1));
            }
        }
        return arr;
    }

    private static void printThreeDimArray(int[][][] arr) {
        System.out.println("Three-dimension array is: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    System.out.print(arr[i][j][k] + " ");
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }

    private static void increaseElementsOfThreeDimArray(int[][][] arr) {
        System.out.println("--------------------------------");
        System.out.println("Enter the value,which you want elements of the array will be increased by.");
        int increaseValue = checkWholeNumber();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++)
                    arr[i][j][k] +=increaseValue;
            }
        }
    }
}
