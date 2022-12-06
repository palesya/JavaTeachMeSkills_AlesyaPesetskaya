package Patterns.Creational.Prototype;

public class UserFactory {

    private User user;

    public UserFactory(User user) {
        this.user = user;
    }

    User cloneUser() {
        return (User) user.copy();
    }

}
