package lecture_16.task3;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        int sum = list.stream()
                .filter(el -> el % 2 == 0)
                .map(Main::factorial)
                .mapToInt(el -> el)
                .sum();

        System.out.println(sum);
    }

    public static int factorial(int num) {
        if (num > 1) {
            return num * factorial(num - 1);
        } else {
            return 1;
        }
    }
}
