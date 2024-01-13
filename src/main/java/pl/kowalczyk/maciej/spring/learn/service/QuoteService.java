package pl.kowalczyk.maciej.spring.learn.service;

import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.spring.learn.repository.AuthorRepository;
import pl.kowalczyk.maciej.spring.learn.repository.QuoteRepository;

import java.util.logging.Logger;

@Service
public class QuoteService {

    private static final Logger LOGGER = Logger.getLogger(QuoteService.class.getName());

    private QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public void list() {
        LOGGER.info("list()");
        quoteRepository.list();
        LOGGER.info("list(...) = ");
    }
}
