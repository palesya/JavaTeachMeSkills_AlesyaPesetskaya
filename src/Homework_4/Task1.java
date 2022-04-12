package Homework_4;

import java.util.Arrays;

import static Homework_4.BaseMethods.createArray;
import static Homework_4.BaseMethods.removeAllFoundValues;

public class Task1 {
    public static void main(String[] args) {
        int[] array = createArray();
        System.out.println("Initial array: " + Arrays.toString(array));
        //Удалите все вхождения заданного числа из массива.
        //В результате должен быть новый массив без указанного числа.
        int[] arr1 = removeAllFoundValues(array);
        System.out.println("Array with removed numbers: " + Arrays.toString(arr1));
    }
}
