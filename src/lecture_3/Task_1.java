package lecture_3;

public class Task_1 {
    public static void main(String[] args) {
        getSwitchMethod(0);
        getForMethod(2);
        getWhileMethod();
        getDoWhileMethod();
        getWhileMethodWithBreak();
        getForMethodWithBreak();
        getWhileMethodWithContinue();
    }

    public static void getSwitchMethod(int a) {
        switch (a) {
            case 0:
                System.out.println("You have entered 0");
                break;
            case 1:
                System.out.println("You have entered 1");
                break;
            case 2:
            case 3:
                System.out.println("You have entered 2 or 3");
                break;
            default:
                System.out.println("You've entered not 0,1,2 or 3");
                break;
        }

    }

    public static void getForMethod(int a) {
        System.out.println("For method: ");
        for (int i = 0; i < a; i++) {
            System.out.println("i = " + i);
        }
    }

    public static void getWhileMethod() {
        System.out.println("While method: ");
        int b = 5;
        int c = 40;
        while (b <= c) {
            b *= 2;
            System.out.println("b = " + b);
        }
    }

    public static void getDoWhileMethod() {
        System.out.println("Do-while method: ");
        int a = 10;
        do {
            a += 15;
            System.out.println("a = " + a);
        }
        while (a <= 100);
    }

    public static void getWhileMethodWithBreak() {
        System.out.println("Method with break: ");
        int a = 5;
        int b = 1;
        while (b < 10) {
            if (b == a) {
                break;
            }
            System.out.println("b=" + b);
            b++;
        }
    }

    public static void getForMethodWithBreak() {
        System.out.println("For method with break: ");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Hello " + i);
            for (int a = 1; a <= 10; a++) {
                System.out.println("Bye " + a);
                if (a == 3) break;
            }
            if (i == 2) break;
        }
    }

    public static void getWhileMethodWithContinue() {
        System.out.println("Method with continue: ");
        int i = 5;
        while (i < 30) {
            i += 5;
            System.out.println("i=" + i);
            if (i == 20) continue;
            System.out.println("Hello!" + i);
        }
    }

}


