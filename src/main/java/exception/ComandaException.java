package exception;

public class ComandaException extends RuntimeException {
    public ComandaException(String message) {
        super(message);
    }
    public ComandaException(String message, Throwable cause) {super(message,cause);}
}
