package pl.kowalczyk.maciej.spring.learn.api.exception.author;

public class AuthorDeleteException extends AuthorException {

    public AuthorDeleteException(String message) {
        super(message);
    }

    public AuthorDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
