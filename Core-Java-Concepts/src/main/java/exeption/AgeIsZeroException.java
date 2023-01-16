package exeption;

public class AgeIsZeroException extends RuntimeException { //custom checked exception
    public AgeIsZeroException(String message) {
        super(message);
    }

    public AgeIsZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public AgeIsZeroException(Throwable cause) {
        super(cause);
    }
}
