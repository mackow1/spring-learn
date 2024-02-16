package pl.kowalczyk.maciej.spring.learn.api.exception.author;

import pl.kowalczyk.maciej.spring.learn.api.exception.SpringLearnApplicationException;

public class AuthorException extends SpringLearnApplicationException {
    
    public AuthorException(String message) {
        super(message);
    }

    public AuthorException(String message, Throwable cause) {
        super(message, cause);
    }
}
