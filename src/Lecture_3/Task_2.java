package Lecture_3;

public class Task_2 {
    public static void main(String[] args) {
        getFactorialFor(4);
        getFactorialWhile(4);
        getFactorialDoWhile(4);
    }

    public static void getFactorialFor(int a) {
        int factorial = 1;
        for (int i = 1; i <= a; i++) {
            factorial = factorial * i;
        }
        System.out.println("Factorial of " + a + " = " + factorial);
    }

    public static void getFactorialWhile(int a) {
        int factorial = 1;
        int i = 1;
        while (i <= a) {
            factorial = factorial * i;
            i++;
        }
        System.out.println("Factorial of " + a + " = " + factorial);
    }

    public static void getFactorialDoWhile(int a) {
        int factorial = 1;
        int i = 1;
        do
         {
            factorial = factorial * i;
            i++;
        }
        while (i <= a);
        System.out.println("Factorial of " + a + " = " + factorial);
    }

}
