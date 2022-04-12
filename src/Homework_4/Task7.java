package Homework_4;

import java.util.Arrays;

import static Homework_4.BaseMethods.createArray;

public class Task7 {
    public static void main(String[] args) {
        int[] array = createArray();
        System.out.println("Initial array: " + Arrays.toString(array));
        bubbleSorting(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void bubbleSorting(int[] array) {
        int temp;
        int arrLength = array.length;
        for (int i = 0; i < arrLength - 1; i++)
            for (int j = 0; j < arrLength - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
    }
}

