package homework_15;

public class MyService {

    void process(int input, String line, int value, MyInterface myInterface) {
        myInterface.doSomething(input, line, value);
    }
}
