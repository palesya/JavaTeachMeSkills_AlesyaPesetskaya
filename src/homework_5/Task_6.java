package homework_5;

import java.util.Arrays;

import static baseMethodsForTwoDimArrays.BaseMethods.generateTwoDimArray;

public class Task_6 {
    public static void main(String[] args) {
        int[][] arr = generateTwoDimArray();
        System.out.println("Initial array is: "+Arrays.deepToString(arr));
        sortArrayInLines(arr);
        System.out.println("Sorted array is: "+Arrays.deepToString(arr));
    }

    private static void sortArrayInLines(int[][] arr) {
        int temp;
        for (int k = 0; k < arr[0].length - 1; k++) {
            for (int i = 0; i < arr.length; i++) {
                //-k - значит, что на каждом новом круге мы не будет проходить последнее в ряду число, т.к. оно наибольшее в ряду
                for (int j = 0; j < arr[0].length - 1 - k; j++) {
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

