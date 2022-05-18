package homework_11;

public class RepositoryLengthException extends Exception {

    UserInputRepository inputRepository;

    public RepositoryLengthException(UserInputRepository inputRepository, String message) {
        super(message);
        this.inputRepository = inputRepository;
    }

    public UserInputRepository getInputRepository() {
        return inputRepository;
    }

    @Override
    public String getMessage() {
        return super.getMessage()+"\nEnter 'get' to see the first value from repository and to delete it." +
                "\nOr enter 'exit' to finish program running. "+
                "\n--------------------------------------------";
    }
}
