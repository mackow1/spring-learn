package pl.kowalczyk.maciej.spring.learn.api.exception.author;

public class AuthorUpdateException extends AuthorException {

    public AuthorUpdateException(String message) {
        super(message);
    }

    public AuthorUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
