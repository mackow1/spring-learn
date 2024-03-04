package pl.kowalczyk.maciej.spring.learn.api.exception.user;

import pl.kowalczyk.maciej.spring.learn.api.exception.SpringLearnApplicationException;

public class UserException extends SpringLearnApplicationException {
    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
