package homework_4;

import java.util.Arrays;

import static baseMethodsForOneDimArrays.BaseMethods.checkIfFound;
import static baseMethodsForOneDimArrays.BaseMethods.generateOneDimArray;

public class Task0 {
    public static void main(String[] args) {
        int[] array = generateOneDimArray();
        System.out.println("Initial array: " + Arrays.toString(array));
        // сообщение о том, входит ли заданное число в массив или нет.
        checkIfFound(array);
    }
}
