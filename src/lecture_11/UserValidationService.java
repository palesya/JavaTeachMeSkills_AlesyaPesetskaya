package lecture_11;

public class UserValidationService {

    public void validate(User user) throws UserValidationException {
        if(user.getName().isBlank()||user.getName()==null){
            throw new UserNameValidationException(user,"name is empty");
        }
        else if(user.getAge()<18){
            throw new UserAgeValidationException(user,"age must be greater than 17");
        }
        else {
            System.out.println("User is valid");
        }
    }
}
