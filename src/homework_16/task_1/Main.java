package homework_16.task_1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            intList.add(random.nextInt(51));
        }
        System.out.println("All elements of the list (from 1 to 50):");
        System.out.println(intList);

        List<Integer> intListDistinct = intList
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique elements of the list:");
        System.out.println(intListDistinct);

        List<Integer> intListEven = intList
                .stream()
                .filter(el -> el % 2 == 0 && el >= 7 && el <= 17)
                .collect(Collectors.toList());
        System.out.println("Even elements from 7 to 17:");
        System.out.println(intListEven);

        List<Integer> intDoubled = intList
                .stream()
                .map(el -> el * 2)
                .collect(Collectors.toList());

        System.out.println("Doubled elements of the original list:");
        System.out.println(intDoubled);

        List<Integer> intFirstFourSorted = intList
                .stream()
                .sorted((el1,el2) -> el1 > el2?1:-1)
                .limit(4)
                .collect(Collectors.toList());

        System.out.println("Sort ascending first four elements:");
        System.out.println(intFirstFourSorted);

        int listSize = intList.size();
        System.out.println("Size of the original list:");
        System.out.println(listSize);

        OptionalDouble average = intList
                .stream()
                .mapToInt(el -> el)
                .average();

        System.out.println("Average of all elements of the original list:");
        System.out.printf("%.2f",average.getAsDouble());

    }
}
