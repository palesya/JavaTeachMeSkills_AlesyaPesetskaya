package homework_14.task2;

import java.util.*;

public class ArrayService {

    private Map<Integer, Integer> getMapOfValuesAndNumberOfRepeats(int[] array) {
        Map<Integer, Integer> duplicates = new HashMap<>();
        for (int i : array) {
            duplicates.put(i, duplicates.getOrDefault(i, 0) + 1);
        }
        return duplicates;
    }

    public void findValuesWithMaxRepeats(int[] array) {
        Map<Integer, Integer> duplicates = getMapOfValuesAndNumberOfRepeats(array);
        Map<Integer, Integer> maxValues = new HashMap<>();
        Integer maxRepeats = null;
        for (Map.Entry<Integer, Integer> entry : duplicates.entrySet()) {
            if (maxRepeats == null || entry.getValue() > maxRepeats) {
                maxRepeats = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : duplicates.entrySet()) {
            if (Objects.equals(entry.getValue(), maxRepeats)) {
                maxValues.put(entry.getKey(), entry.getValue());
                System.out.println("The maximum number of repeats in array is " + entry.getValue() + " for number " + entry.getKey());
            }
        }
    }
}
