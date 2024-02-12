package pl.kowalczyk.maciej.spring.learn.api.exception.author;

public class AuthorCreateException extends AuthorException {

    public AuthorCreateException(String message) {
        super(message);
    }

    public AuthorCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
