package homework_11;

public class RepositoryLengthException extends Exception {


    public RepositoryLengthException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage()+"\nEnter 'get' to see the first value from repository and to delete it." +
                "\nOr enter 'exit' to finish program running. "+
                "\n--------------------------------------------";
    }
}
