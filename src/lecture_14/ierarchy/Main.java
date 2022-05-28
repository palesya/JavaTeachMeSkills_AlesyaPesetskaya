package lecture_14.ierarchy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DBService<Cl3> service = new DBServiceImpl();
        service.save(new Cl3());

        List<? super Cl2> list1 = new ArrayList<>();

        list1.add(new Cl2());
        list1.add(new Cl3());

        Object object = list1.get(0);
        System.out.println(object);

        for (Object o : list1) {
            System.out.println(o);
        }

        System.out.println("------------------------------");

        List<? extends Cl2> list2 = Arrays.asList(new Cl3(), new Cl2());
        Cl2 cl2 = list2.get(0);
        System.out.println(cl2);

        for (Cl2 el : list2) {
            System.out.println(el);
        }

        List<Number> numberList = new ArrayList<>();
        numberList.add(new Integer(10));
        numberList.add(new Long(10L));
        numberList.add(new Double(23));

        for (Number el : numberList) {
            System.out.println(el);
        }

    }
}
