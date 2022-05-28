package lecture_14.comparator;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class MainQueue {
    public static void main(String[] args) {

        //Stack<User> userStack = new Stack<>();

        Queue<User> users = new ArrayDeque<>();
        users.add(new User("U1",12));
        users.add(new User("U2",20));
        users.add(new User("U3",25));
        users.add(new User("U4",30));
        users.add(new User("U5",35));

        System.out.println(users.peek());
        System.out.println(users.peek());

        System.out.println(users.poll());
        System.out.println(users.poll());

        System.out.println(users);
    }
}
