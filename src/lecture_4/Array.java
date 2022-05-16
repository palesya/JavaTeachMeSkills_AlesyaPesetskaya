package lecture_4;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[5];
        arr[0] = 7;
        arr[1] = 56;
        arr[2] = 2;
        arr[3] = 0;
        arr[4] = 6;
        System.out.println("_____________________");
        printArray(arr);

        System.out.println("_____________________");
        int[] arr2 = new int[]{2, 5, 6, 4};
        printArray(arr2);
        System.out.println("Length of array = " + arr2.length);

        System.out.println("_____________________");
        int[] arr3 = {4, 8, 2, 5, 6, 4};
        printArray(arr3);
        System.out.println("Length of array = " + arr3.length);

        System.out.println("_____________________");
        String[] arr4 = new String[8];
        arr4[0] = "Hello";
        arr4[5] = "Goodbye";
        printArrayForEach(arr4);

        System.out.println("_____________________");
        fillArray(arr);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }

    public static void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }

    public static void printArrayForEach(String[] arr) {
        for (String str : arr) {
            System.out.println("For each = " + str);
        }
    }

    public static void fillArray(int[] arr) {
        System.out.println("Fill array. Enter the whole values " + arr.length + " times");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            if (scanner.hasNextInt()) {
                arr[i] = scanner.nextInt();
            } else {
                System.out.println("You've entered not whole number");
            }
        }

    }
}
