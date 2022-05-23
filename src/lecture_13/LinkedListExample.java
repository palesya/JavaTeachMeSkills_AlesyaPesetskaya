package lecture_13;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        List<String> lines = new LinkedList<>();
        lines.add("Alesya");
        lines.add("very");
        lines.add("Cool");
        lines.add(1, "is");
        lines.add("add1");
        lines.add("add2");
        lines.remove("add1");
        lines.remove(2);
        String s = lines.get(0);
        String s1 = lines.remove(3);
        System.out.println(s);
        System.out.println(s1);

        boolean add4 = lines.contains("Alesya");
        System.out.println(add4);

        System.out.println(lines);

        //пройти по коллекции

        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }

        for (String el : lines) {
            System.out.println(el);
        }

        Iterator<String> iterator = lines.iterator();

        while (iterator.hasNext()) {
            String el = iterator.next();
            System.out.println(el);
        }

    }
}
