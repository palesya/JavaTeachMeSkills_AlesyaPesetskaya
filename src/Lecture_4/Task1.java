package Lecture_4;

import java.util.Arrays;

import static BaseMethodsForOneDimArrays.BaseMethods.checkWholeNumber;

public class Task1 {
    public static void main(String[] args) {
        int[] arr = {4, 56, 2, 8, 45, 7, 3, 65, 18, 33};
        checkIfFoundAndReturnIndex(arr);
        int[] arr1 = removeFromArray(arr);
        Array.printArray(arr1);
        int maxValue = findMaxValue(arr);
        int minValue = findMinValue(arr);
        System.out.println("Min value of array is: " + minValue);
        System.out.println("Max value of array is: " + maxValue);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Index of found element= " + Arrays.binarySearch(arr, 7));
        int[] copyArray = new int[arr.length];
        System.arraycopy(arr, 0, copyArray, 0, arr.length);
        System.out.println(Arrays.toString(copyArray));
    }

    public static int checkIfFoundAndReturnIndex(int[] arr) {
        int numberToFind = checkWholeNumber();
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == numberToFind) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            System.out.println("Number " + numberToFind + " exists in array.");
        } else {
            System.out.println("Number " + numberToFind + " doesn't exist in array.");
        }
        return index;
    }

    public static int[] removeFromArray(int[] arr) {
        int[] arr1;
        int index = checkIfFoundAndReturnIndex(arr);
        if (index >= 0) {
            arr1 = new int[arr.length - 1];
            for (int i = 0; i < index; i++) {
                arr1[i] = arr[i];
            }
            for (int i = index + 1; i < arr.length; i++) {
                arr1[i - 1] = arr[i];
            }
        } else {
            arr1 = arr;
        }
        return arr1;
    }

    private static int findMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    private static int findMinValue(int[] arr) {
        int minValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }
        return minValue;
    }
}

