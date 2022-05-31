package lecture_15.task_2;

public class StringService {

    void process(String text, int count, StringInterface str) {
        for (int i = 0; i < count; i++) {
            str.doSomething(text);
        }
    }

}
