package BaseMethodsForOneDimArrays;

import java.util.Scanner;

public abstract class BaseMethods {
    public static int[] generateOneDimArray() {
        System.out.println("--------------------------------");
        System.out.println("Enter the length of Array.");
        int arrayLength = checkWholeNumber();
        return createArray(arrayLength);
    }

    public static void checkIfFound(int[] arr) {
        System.out.println("--------------------------------");
        System.out.println("Enter the number for search.");
        int numberToFind = checkWholeNumber();
        int count = countNumberOfMatches(arr, numberToFind);
        if (count > 0) {
            System.out.println("Number " + numberToFind + " exists in array.");
        } else {
            System.out.println("Number " + numberToFind + " doesn't exist in array.");
        }
    }

    public static int checkWholeNumber() {
        Scanner scanner = new Scanner(System.in);
        boolean validValue = false;
        int number = 0;
        while (!validValue) {
            System.out.println("Please enter the whole number.");
            if (!scanner.hasNextInt()) {
                System.out.println("You've entered invalid value.");
                scanner.next();
            } else {
                number = scanner.nextInt();
                validValue = true;
            }
        }
        return number;
    }

    public static int[] removeAllFoundValues(int[] arr) {
        System.out.println("--------------------------------");
        System.out.println("Enter the number to delete it from array.");
        int numberToFind = checkWholeNumber();
        int numberOfMatches = countNumberOfMatches(arr, numberToFind);
        int[] arr1 = new int[arr.length - numberOfMatches];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] != numberToFind) {
                arr1[j] = arr[i];
                j++;
            }
        }
        return arr1;
    }

    public static int countNumberOfMatches(int[] arr, int numberToFind) {
        int count = 0;
        for (int value : arr) {
            if (value == numberToFind) {
                count++;
            }
        }
        System.out.println("The count of matches with number " + numberToFind + " is: " + count);
        return count;
    }

    public static int findMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        System.out.println("Max value of array is: " + maxValue);
        return maxValue;
    }

    public static int findMinValue(int[] arr) {
        int minValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }
        System.out.println("Min value of array is: " + minValue);
        return minValue;
    }

    public static double countAverage(int[] arr) {
        int sumOfAllElements = 0;
        for (int i = 0; i < arr.length; i++) {
            sumOfAllElements += arr[i];
        }
        double avg = (double) sumOfAllElements / arr.length;
        System.out.println("The average number is: " + avg);
        return avg;
    }

    public static int[] createArrayOfLength(int arrayLength) {
        System.out.println("--------------------------------");
        return createArray(arrayLength);
    }

    private static int[] createArray(int arrayLength) {
        System.out.println("Enter the max value of Array.");
        int maxValue = checkWholeNumber();
        int[] arr = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
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

    public static void selectionSort(int[] array) {
        int indexOfMinElement;
        int arrLength = array.length;
        for (int i = 0; i < arrLength - 1; i++) {
            indexOfMinElement = i;
            for (int j = i + 1; j < arrLength; j++) {
                if (array[j] < array[indexOfMinElement]) {
                    indexOfMinElement = j;
                }
            }
            int temp = array[indexOfMinElement];
            array[indexOfMinElement]=array[i];
            array[i]=temp;
        }
    }
}