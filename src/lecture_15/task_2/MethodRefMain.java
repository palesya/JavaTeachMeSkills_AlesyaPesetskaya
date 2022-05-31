package lecture_15.task_2;

public class MethodRefMain {

    public static void main(String[] args) {

        MathService service = new MathService();
        service.process(1, 2, Math::pow);

    }
}
