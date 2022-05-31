package lecture_15.task_1;

public interface MyFunctionalInterface {

    void process (String text);

    default String print(){
        return "text";
    }
}
