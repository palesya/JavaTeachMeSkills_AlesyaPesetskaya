package Homework_5;

public class Task_2 {
    public static void main(String[] args) {
        generateChessBoard();
    }

    public static void generateChessBoard() {
        System.out.println("--------------------------------");
        String[][] arr = new String[8][8];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length - 1; j++) {
                if (i % 2 == 0) {
                    arr[i][j] = "W";
                    arr[i][j + 1] = "B";
                    System.out.print(arr[i][j] + " " + arr[i][j + 1] + " ");
                } else {
                    arr[i][j] = "B";
                    arr[i][j + 1] = "W";
                    System.out.print(arr[i][j] + " " + arr[i][j + 1] + " ");
                }
                j++;
            }
            System.out.println();
        }
    }
}
