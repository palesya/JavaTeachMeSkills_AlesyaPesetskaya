package Homework_4;

import java.util.Arrays;
import java.util.Scanner;

import static BaseMethodsForOneDimArrays.BaseMethods.checkWholeNumber;

public class Task4 {
    public static void main(String[] args) {
        int[] arr=generateArray();
        System.out.println("Generated array: "+Arrays.toString(arr));
        int[] evenArr=createEvenArray(arr);
        System.out.println("Generated even array: "+Arrays.toString(evenArr));
    }

    public static int[] generateArray() {
        int length = checkArrayLength();
        System.out.println("Enter the max value of Array.");
        int maxValue = checkWholeNumber();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    public static int checkArrayLength() {
        Scanner scanner = new Scanner(System.in);
        boolean validValue = false;
        int length = 0;
        while (!validValue) {
            System.out.println("Enter the length of array (in range(5,10]):");
            if (!scanner.hasNextInt()) {
                System.out.println("You've entered invalid value.");
                scanner.next();
            } else {
                length = scanner.nextInt();
                if (length <= 5 || length > 10) {
                    System.out.println("You've entered invalid value.");
                } else {
                    validValue = true;
                }
            }
        }
        return length;
    }

    private static int countEven(int [] arr) {
        int count = 0;
        for (int i = 0; i <= arr.length; i++) {
            if (i % 2 == 0) {
                count += 1;
            }
        }
        return count;
    }

    private static int[] createEvenArray(int [] arr) {
        int countOfEvenElements=countEven(arr);
        int[] array = new int[countOfEvenElements];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                array[j] = arr[i];
                j++;
            }
        }
        return array;
    }

}
