package homework_4;

import java.util.Arrays;

import static baseMethodsForOneDimArrays.BaseMethods.*;

public class Task7 {
    public static void main(String[] args) {
        int[] array = generateOneDimArray();
        System.out.println("Initial array: " + Arrays.toString(array));
        bubbleSorting(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}

