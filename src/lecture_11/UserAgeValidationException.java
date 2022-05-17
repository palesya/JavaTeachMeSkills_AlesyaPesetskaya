package lecture_11;

public class UserAgeValidationException extends UserValidationException {

    public UserAgeValidationException(User user, String message) {
        super(user, message);
    }

    @Override
    public String getMessage() {
        return super.getMessage()+"\nName is empty \n"+getUser();
    }
}
