package pl.kowalczyk.maciej.spring.learn.api.exception;

public class ApartmentException extends SpringLearnApplicationException {

    public ApartmentException(String message) {
        super(message);
    }

    public ApartmentException(String message, Throwable cause) {
        super(message, cause);
    }
}
