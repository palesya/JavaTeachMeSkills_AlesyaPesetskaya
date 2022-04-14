package Homework_4;

import java.util.Arrays;

import static BaseMethodsForOneDimArrays.BaseMethods.*;

public class Task3 {
    public static void main(String[] args) {
        int[] array1 = createArrayOfLength(5);
        int[] array2 = createArrayOfLength(5);
        System.out.println("Initial array1: " + Arrays.toString(array1));
        System.out.println("Initial array2: " + Arrays.toString(array2));
        checkAverages(array1,array2);
    }

    public static void checkAverages(int[] array1,int[] array2){
        double avg1=countAverage(array1);
        double avg2=countAverage(array2);
        if(avg1>avg2){
            System.out.println("The average value of the first array is larger.");
        }else if (avg2>avg1){
            System.out.println("The average value of the second array is larger.");
        }else {
            System.out.println("The average values of both arrays equals between themselves.");
        }
    }
}
