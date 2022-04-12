package Homework_4;

import java.util.Arrays;

import static Homework_4.BaseMethods.checkIfFound;
import static Homework_4.BaseMethods.createArray;

public class Task0 {
    public static void main(String[] args) {
        int[] array = createArray();
        System.out.println("Initial array: " + Arrays.toString(array));
        // сообщение о том, входит ли заданное число в массив или нет.
        checkIfFound(array);
    }
}
