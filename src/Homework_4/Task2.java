package Homework_4;

import java.util.Arrays;

import static BaseMethodsForOneDimArrays.BaseMethods.*;

public class Task2 {
    public static void main(String[] args) {
        int[] array = generateOneDimArray();
        System.out.println("Initial array: " + Arrays.toString(array));
        findMinValue(array);
        findMaxValue(array);
        countAverage(array);
    }
}
