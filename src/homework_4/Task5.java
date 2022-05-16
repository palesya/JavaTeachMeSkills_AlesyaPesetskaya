package homework_4;

import java.util.Arrays;

import static baseMethodsForOneDimArrays.BaseMethods.generateOneDimArray;

public class Task5 {
    public static void main(String[] args) {
        int[] array = generateOneDimArray();
        System.out.println("Initial array: " + Arrays.toString(array));
        replaceElements(array);
        System.out.println("Array with zeroes: " + Arrays.toString(array));
    }

    public static void replaceElements(int[]arr){
        for(int i=0;i<arr.length;i++){
            if (i% 2 == 1){
                arr[i] = 0;
            }
        }
    }
}
