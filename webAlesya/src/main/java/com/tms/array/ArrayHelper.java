package com.tms.array;

import java.util.Arrays;
import java.util.Random;

public class ArrayHelper {

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }

    public int[][] fillArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = getRandomNumber();
            }
        }
        return array;
    }

    public int[][] printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }

    public int[][] sortArray(int[][] array) {
        int[][] sortedArray = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            int[] arr = array[i];
            Arrays.sort(arr);
            sortedArray[i] = arr;
        }
        return sortedArray;
    }

    public void sortOneDimArray(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; length--) {
            for (int j = i; j < length; j++) {
                int firstEl = array[j - 1];
                if (firstEl > array[j]) {
                    array[j - 1] = array[j];
                    array[j] = firstEl;
                }
            }
        }
    }

    public int factorial(int number) {
        int result;
        if (number == 1) {
            return 1;
        }
        result = factorial(number - 1) * number;
        return result;
    }

    public int fibonachi(int number) {
        if (number == 1) {
            return 0;
        }
        if (number == 2) {
            return 1;
        }else
        {
            return fibonachi(number-1)+fibonachi(number-2);
        }
    }
}

