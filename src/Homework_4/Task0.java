package Homework_4;

import java.util.Arrays;

import static BaseMethodsForOneDimArrays.BaseMethods.checkIfFound;
import static BaseMethodsForOneDimArrays.BaseMethods.generateOneDimArray;

public class Task0 {
    public static void main(String[] args) {
        int[] array = generateOneDimArray();
        System.out.println("Initial array: " + Arrays.toString(array));
        // сообщение о том, входит ли заданное число в массив или нет.
        checkIfFound(array);
    }
}
