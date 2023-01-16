package exeption;

public class AgeLessThanZeroException extends IllegalArgumentException { //custom checked exception
    public AgeLessThanZeroException(String message) {
        super(message);
    }

    public AgeLessThanZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public AgeLessThanZeroException(Throwable cause) {
        super(cause);
    }
}
