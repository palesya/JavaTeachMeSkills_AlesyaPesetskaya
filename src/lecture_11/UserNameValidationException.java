package lecture_11;

public class UserNameValidationException extends UserValidationException{

    public UserNameValidationException(User user,String message) {
        super(user, message);
    }

    @Override
    public String getMessage() {
        return super.getMessage()+"\nName is empty \n"+getUser();
    }
}
