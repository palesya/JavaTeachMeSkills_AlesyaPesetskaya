package Lecture_5;

import static BaseMethodsForTwoDimArrays.BaseMethods.generateTwoDimArray;
import static BaseMethodsForTwoDimArrays.BaseMethods.printTwoDimArray;

public class Task1 {
    public static void main(String[] args) {
        int[][] arr = generateTwoDimArray();
        printTwoDimArray(arr);
        replaceNotEvenElements(arr);
        printTwoDimArray(arr);
    }

    public static void replaceNotEvenElements(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if ((i % 2 == 1) || (j % 2 == 1)) {
                    arr[i][j] = 0;
                }
            }
        }
    }
}
