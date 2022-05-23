package homework_11;

public class RepositoryEmptyException extends Exception {

    public RepositoryEmptyException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage()+"\nEnter any string value and press Enter to save in repository." +
                "\nOr enter 'exit' to finish program running. "+
                "\n--------------------------------------------";
    }
}
