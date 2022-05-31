package homework_14.task2;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{4, 7, 8, 3, 4, 5, 7, 2, 8, 9, 2, 3, 0, 1, 5, 8, 2, 0, 5, 7, 5, 3, 6, 7};
        ArrayService service = new ArrayService();
        service.findValuesWithMaxRepeats(array);
    }
}
