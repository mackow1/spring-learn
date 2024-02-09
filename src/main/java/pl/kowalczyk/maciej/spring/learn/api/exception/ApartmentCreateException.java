package pl.kowalczyk.maciej.spring.learn.api.exception;

public class ApartmentCreateException extends ApartmentException {

    public ApartmentCreateException(String message) {
        super(message);
    }

    public ApartmentCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
