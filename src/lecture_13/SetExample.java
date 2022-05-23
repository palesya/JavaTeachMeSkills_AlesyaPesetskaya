package lecture_13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<Child> children = new HashSet<>();

        children.add(new Child(5, "Ivan"));
        children.add(new Child(4,"Mary"));
        children.add(new Child(5, "Ivan"));

        boolean contains = children.contains(new Child(5,"Ivan"));

        System.out.println(contains);
        System.out.println(children);

        Iterator<Child> iterator = children.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
