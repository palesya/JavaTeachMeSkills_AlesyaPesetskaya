package homework_5;

import static baseMethodsForTwoDimArrays.BaseMethods.generateTwoDimArray;
import static baseMethodsForTwoDimArrays.BaseMethods.printTwoDimArray;

public class Task_4 {
    public static void main(String[] args) {
        int[][] arr = generateTwoDimArray();
        printTwoDimArray(arr);
        countSumOfAllElements(arr);
    }

    private static void countSumOfAllElements(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println("Sum of all elements in array = "+sum);
    }
}
