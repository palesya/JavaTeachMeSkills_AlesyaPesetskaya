public class UserService {

    public User save(User user) {
        if (user.getName() != null && user.getPassword() != null) {
            user.setId("1");
            System.out.println("saved");
            return user;
        }
        return null;
    }
}
