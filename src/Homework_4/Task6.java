package Homework_4;

import java.util.Arrays;
import java.util.Random;

import static Homework_4.BaseMethods.checkWholeNumber;

public class Task6 {
    public static void main(String[] args) {
        String[] names=generateArrayFromNames();
        Arrays.sort(names);
        System.out.println("Sorted array: " + Arrays.toString(names));
    }

    public static String[] generateArrayFromNames() {
        String[] names = {"Alesya", "Bob", "Ivan", "Nikolay", "Pavel", "Kate", "Sofi", "Victor", "Petya", "Anna", "Vladimir","Melany","Alex","Andrey"};
        Random random = new Random();
        System.out.println("--------------------------------");
        System.out.println("Enter the length of Array.");
        int arrayLength = checkWholeNumber();
        String[] arr = new String[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            int rnd = new Random().nextInt(names.length);
            arr[i] = names[rnd];
        }
        return arr;
    }

}
