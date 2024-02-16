package pl.kowalczyk.maciej.spring.learn.api.exception.apartment;

import pl.kowalczyk.maciej.spring.learn.api.exception.SpringLearnApplicationException;

public class ApartmentException extends SpringLearnApplicationException {

    public ApartmentException(String message) {
        super(message);
    }

    public ApartmentException(String message, Throwable cause) {
        super(message, cause);
    }
}
