package lecture_15.task_3;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    static final int maxLength = 2;

    public static void main(String[] args) {

        User user = new User("Test", 10);

        UserService userService = new UserService();

        Predicate<User> validForSave = us -> us.getName() != null && us.getName().length() > maxLength;
        Predicate<User> validForDelete = us -> us.getId() != 0;
        Predicate<User> validForUpdate = us -> us.getId() != 0 && us.getName() != null && us.getName().length() > 2;

        Consumer<User> save = us -> {
            if (us == null){
                try {
                    throw new NoSuchFieldException();
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            }
                System.out.println("User is saved: " + us);
        };
        Consumer<User> delete = us -> System.out.println("User is deleted: " + us);
        Consumer<User> update = us -> System.out.println("User is updated: " + us);

        userService.processUser(user, validForSave, save);
        userService.processUser(user, validForDelete, delete);
        userService.processUser(user, validForUpdate, update);

    }
}
