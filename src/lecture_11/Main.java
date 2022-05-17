package lecture_11;

public class Main {
    public static void main(String[] args) throws UserValidationException {
        User user = new User("Petya", 5);
        UserValidationService service = new UserValidationService();
        try {
            service.validate(user);
        } catch (UserNameValidationException exc) {
            System.out.println(exc.getMessage());
        }
        catch (UserAgeValidationException exc) {
            System.out.println(exc.getMessage());
        }

        DBUserRepositoryService repositoryService=new DBUserRepositoryService();
        try {
            repositoryService.addUser(user);
            repositoryService.deleteUser(user);
        } catch (DBException e) {
            e.printStackTrace();
        }

    }
}
