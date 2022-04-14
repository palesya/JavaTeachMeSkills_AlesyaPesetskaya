package Lecture_5;

import java.util.Arrays;

import static BaseMethodsForTwoDimArrays.BaseMethods.printTwoDimArray;

public class MultiArrays {
    public static void main(String[] args) {
        int[][] twoDimArr = new int[2][3];
        twoDimArr[0][0] = 1;
        twoDimArr[0][1] = 2;
        twoDimArr[0][2] = 9;
        twoDimArr[1][0] = 3;
        twoDimArr[1][1] = 4;
        twoDimArr[1][2] = 8;
        float[][][] threeDimArr = new float[3][3][3];
        String[][][][][] fiveDimArr = new String[5][4][5][5][8];

        int[][] twoDimArr2 = new int[][]{{2, 5}, {6, 9}};
        int[][][] threeDimArr2 = new int[][][]{{{1, 4}, {6, 0}}, {{4, 2}, {8, 5}}, {{7, 1}, {8, 5}}};

        System.out.println("Number of lines = " + twoDimArr.length);
        System.out.println("Number of rows = " + twoDimArr[0].length);
        System.out.println("----------------------");
        printTwoDimArray(twoDimArr);

        //зубчатый массив
        int[][] strangeArray = new int[5][];
        strangeArray[0] = new int[]{1, 2, 3, 4, 5};
        strangeArray[1] = new int[]{5, 8, 3};
        strangeArray[2] = new int[]{7};
        strangeArray[3] = new int[]{8, 0, 4, 6, 7, 9, 3};
        strangeArray[4] = new int[]{0, 5, 2};
        printTwoDimArray(strangeArray);
        System.out.println(Arrays.deepToString(strangeArray));

        float[][][] threeArr5 = new float[3][2][5];
        threeArr5[0] = new float[5][2];
        threeArr5[1] = new float[6][8];

        //парковка с номером этажа, и номнром места (ширина, длина)
        boolean[][][] parkingLot = new boolean[3][2][5];
        parkingLot[0][1][0] = true;
        parkingLot[1][0][4] = true;
        printThreeDimArray(parkingLot);

        //заполнение массива через Arrays.fill
        int[] arr=new int [5];
        Arrays.fill(arr,17);
        System.out.println(Arrays.toString(arr));

        //сравнение массивов
        System.out.println("Are arrays equals: "+Arrays.deepEquals(twoDimArr, twoDimArr2));

    }

    public static void printThreeDimArray(boolean[][][] arr) {
        System.out.println("Three-dimension array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Floor number: "+(i+1));
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    System.out.print(arr[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
