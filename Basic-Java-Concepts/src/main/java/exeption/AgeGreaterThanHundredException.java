package exeption;

public class AgeGreaterThanHundredException extends Exception { //custom checked exception
    public AgeGreaterThanHundredException(String message) {
        super(message);
    }

    public AgeGreaterThanHundredException(String message, Throwable cause) {
        super(message, cause);
    }

    public AgeGreaterThanHundredException(Throwable cause) {
        super(cause);
    }
}
