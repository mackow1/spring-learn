package pl.kowalczyk.maciej.spring.learn.api.exception;

public class SpringLearnApplicationException extends Exception {

    public SpringLearnApplicationException(String message) {
        super(message);
    }

    public SpringLearnApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
