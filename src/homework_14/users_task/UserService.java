package homework_14.users_task;


import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class UserService {

    public List<User> findUsersByName(Collection<User> collection, String name) {
        List<User> foundUsers = new ArrayList<>();
        for (User el : collection) {
            if (Objects.equals(el.getName(), name)) {
                foundUsers.add(el);
            }
        }
        return foundUsers;
    }

    public List<User> getUsersBySex(Collection<User> collection, Sex sex) {
        List<User> foundUsers = new ArrayList<>();
        for (User el : collection) {
            if (Objects.equals(el.getSex(), sex)) {
                foundUsers.add(el);
            }
        }
        return foundUsers;
    }

    public List<User> getSortedUsersByAge(Collection<User> collection) {
        List<User> list = new ArrayList<>(collection);
        Comparator<User> compareByAge = Comparator.comparing(user -> user);
        list.sort(compareByAge);
        return list;
    }

}
