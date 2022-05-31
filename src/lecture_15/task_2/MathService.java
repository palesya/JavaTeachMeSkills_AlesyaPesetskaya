package lecture_15.task_2;

public class MathService {

    double process (double value1, double value2, MathInterface math){
        return math.doSomething(value1,value2);
    }

}
