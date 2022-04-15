package Homework_5;

import static BaseMethodsForTwoDimArrays.BaseMethods.generateTwoDimArray;
import static BaseMethodsForTwoDimArrays.BaseMethods.printTwoDimArray;

public class Task_6 {
    public static void main(String[] args) {
        int[][] arr = generateTwoDimArray();
        printTwoDimArray(arr);
        sortArrayInLines(arr);
        printTwoDimArray(arr);
    }

    private static void sortArrayInLines(int[][] arr) {
        int temp;
        for (int k = 0; k < arr[0].length-1; k++) {
            for (int i = 0; i < arr.length; i++) {
                //-k - значит, что на каждом новом круге мы не будет проходить последнее в ряду число, т.к. оно наибольшее в ряду
                for (int j = 0; j < arr[0].length - 1-k; j++) {
                    if (arr[i][j] > arr[i][j + 1]) {
                        temp = arr[i][j];
                        arr[i][j] = arr[i][j + 1];
                        arr[i][j + 1] = temp;
                    }
                }
            }
        }
    }
}
