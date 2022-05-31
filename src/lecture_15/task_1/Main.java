package lecture_15.task_1;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2022,6,1);
        System.out.println(date);

        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");

        MyFunctionalInterface myFInterface = text -> System.out.println(text.toUpperCase());
        myFInterface.process("Hello");

        MyNewFunctionalInterface newFunctionalInterface = () -> System.out.println("Hello world!");
        newFunctionalInterface.process();

        FunctionalInterface fi = (in1, in2) -> System.out.println(in1+in2);
        fi.process("Hello ", "world!");

        FunctionalInterfaceReturn fir = (in1, in2) -> in1+in2;
        String result = fir.process("Hello ", "again");
        System.out.println(result);

        FunctionalInterfaceCount fic = (in,count) -> {
            String result1 = "";
            for(int i=0; i<count; i++){
                result1 = result1+in;
            }
            return result1;
        };

        String process = fic.process("hello!",5);
        System.out.println(process);
    }
}
