package Lecture_3;

public class Lecture_3 {
    public static void main(String[] args) {
        int a = 10;
        int b = 15;
        int c = 12;
        System.out.println(compare(2));
        switchMethod();
    }

    public static String compare(int a) {
        String result;
        if (a < 5) {
            result = "number<5";
        } else if (a == 5) {
            result = "number=5";
        } else {
            result = "number>5";
        }
        return result;
    }

    public static void switchMethod() {
        String str = "Hello";
        switch (str) {
            case "Hello":
                System.out.println("Hello");
                break;
            case "Hello world":
                System.out.println("Hello world");
                break;
            default:
                System.out.println("OOps");
                break;
        }
    }
}
