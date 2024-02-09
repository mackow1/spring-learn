package pl.kowalczyk.maciej.spring.learn.api.exception;

public class ApartmentReadException extends ApartmentException {

    public ApartmentReadException(String message) {
        super(message);
    }

    public ApartmentReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
