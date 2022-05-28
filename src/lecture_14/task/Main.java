package lecture_14.task;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("Ivan", 45),
                new User("Pavel", 45),
                new User("Anna", 14),
                new User("Alesya", 20),
                new User("Sofiya", 18)
        );

        users.sort(new UserComparator());
        System.out.println(users);
    }
}
