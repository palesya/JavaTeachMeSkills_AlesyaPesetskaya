package homework_11;

public class UserInputRepository {
    String[] userRepository;

    public UserInputRepository() {
        this.userRepository = new String[0];
    }

    public String[] getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(String[] userRepository) {
        this.userRepository = userRepository;
    }

}
