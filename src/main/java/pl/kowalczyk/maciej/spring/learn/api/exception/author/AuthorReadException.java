package pl.kowalczyk.maciej.spring.learn.api.exception.author;

public class AuthorReadException extends AuthorException {

    public AuthorReadException(String message) {
        super(message);
    }

    public AuthorReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
