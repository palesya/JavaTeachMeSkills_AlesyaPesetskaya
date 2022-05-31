package lecture_15.task_2;

public class Main {
    public static void main(String[] args) {

        MathService mathService = new MathService();
        double result = mathService.process(4, 5, Double::sum);
        System.out.println(result);

        StringService stringService = new StringService();
        stringService.process("hello", 5, text -> System.out.println(text.toUpperCase()));

        PrintInterface printInterface = System.out::println;

    }
}
