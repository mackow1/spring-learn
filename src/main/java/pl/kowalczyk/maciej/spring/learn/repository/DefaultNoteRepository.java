package pl.kowalczyk.maciej.spring.learn.repository;

import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

//@Component
@Repository
public class DefaultNoteRepository {

    private static final Logger LOGGER = Logger.getLogger(DefaultNoteRepository.class.getName());

    public void list() {
        LOGGER.info("list()");
        LOGGER.info("list(...) = ");
    }

}
