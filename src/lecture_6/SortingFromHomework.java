package lecture_6;

import java.util.Arrays;

import static baseMethodsForOneDimArrays.BaseMethods.*;

public class SortingFromHomework {
    public static void main(String[] args) {
        int[] array = generateOneDimArray();
        System.out.println("Initial array: " + Arrays.toString(array));
        selectionSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
