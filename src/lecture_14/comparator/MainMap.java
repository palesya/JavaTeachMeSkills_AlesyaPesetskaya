package lecture_14.comparator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainMap {
    public static void main(String[] args) {
        Map<String, User> userMap = new HashMap();
        userMap.put("first", new User("U1", 20));
        userMap.put("second", new User("U2", 25));
        userMap.put("first", new User("U3", 30));

        System.out.println(userMap);

        User second = userMap.get("second");
        System.out.println(second);

        User third = userMap.getOrDefault("third", new User("U5", 45));
        System.out.println(third);

        Set<Map.Entry<String, User>> entries = userMap.entrySet();
        for (Map.Entry<String, User> el : entries) {
            System.out.println(el);
        }

        System.out.println("---------------------------------");

        Set<String> strings = userMap.keySet();
        for (String key : strings) {
            System.out.println(userMap.get(key));
        }


    }
}
