package homework_15;

public class MyService {

    void convertLine(int input, String line, MyInterface myInterface) {
        myInterface.performActionWithData(input,line);
    }

    void countFactorial(int input, int value, MyInterface myInterface) {
        myInterface.performActionWithData(input, String.valueOf(value));
    }
}
