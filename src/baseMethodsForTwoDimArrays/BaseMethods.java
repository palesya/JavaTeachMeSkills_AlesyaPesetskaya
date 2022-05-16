package baseMethodsForTwoDimArrays;

import static baseMethodsForOneDimArrays.BaseMethods.checkWholeNumber;

public class BaseMethods {

    public static int[][] generateTwoDimArray() {
        System.out.println("--------------------------------");
        System.out.println("Enter number of lines for array.");
        int numberOfLines = checkWholeNumber();
        System.out.println("Enter number of rows for array.");
        int numberOfRows = checkWholeNumber();
        System.out.println("Enter the max value of Array.");
        int maxValue = checkWholeNumber();
        int[][] arr = new int[numberOfLines][numberOfRows];
        for (int i = 0; i < numberOfLines; i++) {
            for (int j = 0; j < numberOfRows; j++) {
                arr[i][j] = (int) (Math.random() * (maxValue + 1));
            }
        }
        return arr;
    }

    public static int[][] generateSquareArray() {
        System.out.println("--------------------------------");
        System.out.println("Enter size of square array.");
        int size = checkWholeNumber();
        System.out.println("Enter the max value of Array.");
        int maxValue = checkWholeNumber();
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = (int) (Math.random() * (maxValue + 1));
            }
        }
        return arr;
    }

    public static void printTwoDimArray(int[][] arr) {
        System.out.println("Two-dimension array is: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
