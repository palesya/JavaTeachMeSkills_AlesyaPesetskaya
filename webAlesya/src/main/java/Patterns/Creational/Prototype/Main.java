package Patterns.Creational.Prototype;

public class Main {

    public static void main(String[] args) {

        User user = new User(1, "Alesya", 33);
        System.out.println(user);
        UserFactory factory = new UserFactory(user);
        User user1 = factory.cloneUser();

        System.out.println(user1);
    }
}
