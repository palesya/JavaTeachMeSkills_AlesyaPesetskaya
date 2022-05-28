package homework_14.users_task;


import java.util.*;

import static homework_14.users_task.Sex.MAN;
import static homework_14.users_task.Sex.WOMAN;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("Pavel", MAN, 32);
        User user2 = new User("Alesya", WOMAN, 32);
        User user3 = new User("Sofiya", WOMAN, 8);
        User user4 = new User("Melaniya", WOMAN, 3);
        User user5 = new User("Alexey", MAN, 30);
        User user6 = new User("Alexandr", MAN, 30);
        User user7 = new User("Alexandr", MAN, 38);

        //Works for ArrayList, LinkedList, HashSet, TreeSet
        List<User> users = new LinkedList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);

        for (User el : users) {
            System.out.println(el);
        }

        System.out.println("---------------------------------------");

        UserService service = new UserService();
        List<User> foundUsers = service.findUsersByName(users, "Alexandr");
        for (User el : foundUsers) {
            System.out.println(el);
        }

        System.out.println("---------------------------------------");

        List<User> usersBySex = service.getUsersBySex(users, WOMAN);
        for (User el : usersBySex) {
            System.out.println(el);
        }

        System.out.println("---------------------------------------");

        Collection<User> sortedUsersByAge = service.getSortedUsersByAge(users);
        for (User el : sortedUsersByAge) {
            System.out.println(el);
        }
    }
}
