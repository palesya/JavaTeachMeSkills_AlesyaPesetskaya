package homework_14.users_task;


import java.util.*;

public class UserService {

    public List<User> findUsersByName(List<User> collection, String name) {
        List<User> foundUsers = new ArrayList<>();
        for (User el : collection) {
            if (Objects.equals(el.getName(), name)) {
                foundUsers.add(el);
            }
        }
        return foundUsers;
    }

    public List<User> getUsersBySex(List<User> collection, Sex sex) {
        List<User> foundUsers = new ArrayList<>();
        for (User el : collection) {
            if (Objects.equals(el.getSex(), sex)) {
                foundUsers.add(el);
            }
        }
        return foundUsers;
    }

    public List<User> getSortedUsersByAge(List<User> collection) {
        List<User> list = new ArrayList<>(collection);
        Comparator<User> compareByAge = Comparator.comparing(user -> user);
        list.sort(compareByAge);
        return list;
    }

}
