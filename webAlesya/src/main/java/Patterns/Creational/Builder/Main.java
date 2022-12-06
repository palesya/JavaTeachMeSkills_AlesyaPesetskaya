package Patterns.Creational.Builder;

public class Main {
    public static void main(String[] args) {

        User user = new User.Builder()
                .name("Ivan")
                .build();
        System.out.println(user);

    }
}
