package lecture_14.comparable;

import java.util.Set;
import java.util.TreeSet;

public class MainUser {
    public static void main(String[] args) {
        Set<User> users=new TreeSet<>();
        users.add(new User("Vasya",5));
        users.add(new User("Petya",2));
        users.add(new User("Anna",0));
        users.add(new User("Inga",20));
        users.add(new User("Ivan",5));
        System.out.println(users);
    }
}
