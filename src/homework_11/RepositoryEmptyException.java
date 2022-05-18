package homework_11;

public class RepositoryEmptyException extends Exception {

    UserInputRepository inputRepository;

    public RepositoryEmptyException(UserInputRepository inputRepository,String message) {
        super(message);
        this.inputRepository = inputRepository;
    }

    @Override
    public String getMessage() {
        return super.getMessage()+"\nEnter any string value and press Enter to save in repository." +
                "\nOr enter 'exit' to finish program running. "+
                "\n--------------------------------------------";
    }
}
