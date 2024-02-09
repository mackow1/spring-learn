package pl.kowalczyk.maciej.spring.learn.api.exception;

public class ApartmentDeleteException extends ApartmentException {

    public ApartmentDeleteException(String message) {
        super(message);
    }

    public ApartmentDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
