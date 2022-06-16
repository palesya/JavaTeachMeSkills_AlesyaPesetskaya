package lecture_20.exception;

public class CarValidationException extends RuntimeException {

    public CarValidationException(String message) {
        super(message);
    }
}
