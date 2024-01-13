package pl.kowalczyk.maciej.spring.learn.repository;

import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

//@Component
//@Repository
public class QuoteRepository {

    private static final Logger LOGGER = Logger.getLogger(QuoteRepository.class.getName());

    public void list() {
        LOGGER.info("list()");
        LOGGER.info("list(...) = ");
    }
}
