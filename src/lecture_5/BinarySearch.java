package lecture_5;

import baseMethodsForOneDimArrays.BaseMethods;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = BaseMethods.generateOneDimArray();
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        binarySearch(array);
    }

    public static void binarySearch(int[] array) {
        int numberForSearch = BaseMethods.checkWholeNumber();
        int firstIndex=0;
        int lastIndex = array.length - 1;
        int result = -1;
        //условие прекращения поиска - элемент найден или не представлен
        while(firstIndex<=lastIndex){
            int middleIndex=(lastIndex+firstIndex/2);
            //если средний эемент - вернуть его индекс
            if(array[middleIndex]==numberForSearch){
                result=middleIndex;
                break;
            }else if(array[middleIndex]<numberForSearch){
                firstIndex=middleIndex+1;
            }else if (array[middleIndex]>numberForSearch){
                lastIndex=middleIndex-1;
            }
        }
        if(result==-1){
            System.out.println("Number "+numberForSearch+" doesn't exist in array.");
        }else{
        System.out.println("Number "+numberForSearch+" exists in array with index "+result);}
    }
}
