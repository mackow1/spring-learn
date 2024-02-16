package pl.kowalczyk.maciej.spring.learn.api.exception.apartment;

public class ApartmentUpdateException extends ApartmentException {

    public ApartmentUpdateException(String message) {
        super(message);
    }

    public ApartmentUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
