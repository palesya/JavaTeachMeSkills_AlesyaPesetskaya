package lecture_14.comparator;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<User> users = new TreeSet<>(new UserComparator());
        users.add(new User("Vasya", 5));
        users.add(new User("Petya", 2));
        users.add(new User("Anna", 0));
        users.add(new User("Inga", 20));
        users.add(new User("Ivan", 5));
        users.add(new User("Ivan", 20));

        for (User user : users) {
            System.out.println(user);
        }

        System.out.println("------------------------------");
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User next = iterator.next();
            System.out.println(next);
        }

    }
}
