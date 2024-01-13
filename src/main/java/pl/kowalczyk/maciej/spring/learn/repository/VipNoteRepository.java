package pl.kowalczyk.maciej.spring.learn.repository;

import pl.kowalczyk.maciej.spring.learn.service.NoteService;

import java.util.logging.Logger;

public class VipNoteRepository {

    private static final Logger LOGGER = Logger.getLogger(VipNoteRepository.class.getName());


    public void list() {
        LOGGER.info("list()");
        LOGGER.info("list(...) = ");
    }
}
