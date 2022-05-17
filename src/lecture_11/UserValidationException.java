package lecture_11;

public class UserValidationException extends Exception{

    private User user;

    public UserValidationException(User user, String message) {
        super(message);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
