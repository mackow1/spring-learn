package pl.kowalczyk.maciej.spring.learn.api.exception.user;

public class UserDeleteException extends UserException {
    public UserDeleteException(String message) {
        super(message);
    }

    public UserDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
