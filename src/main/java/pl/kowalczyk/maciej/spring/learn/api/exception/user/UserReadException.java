package pl.kowalczyk.maciej.spring.learn.api.exception.user;

public class UserReadException extends UserException {
    public UserReadException(String message) {
        super(message);
    }

    public UserReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
