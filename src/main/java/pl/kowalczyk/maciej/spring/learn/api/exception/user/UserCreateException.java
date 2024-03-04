package pl.kowalczyk.maciej.spring.learn.api.exception.user;

public class UserCreateException extends UserException {
    public UserCreateException(String message) {
        super(message);
    }

    public UserCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
