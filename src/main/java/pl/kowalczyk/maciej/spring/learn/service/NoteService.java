package pl.kowalczyk.maciej.spring.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.spring.learn.repository.DefaultNoteRepository;

import java.util.logging.Logger;

@Service
public class NoteService {

    private static final Logger LOGGER = Logger.getLogger(NoteService.class.getName());

//    @Autowired - może się pojawiać w starszym kodzie ze starszym springiem
    private final DefaultNoteRepository defaultNoteRepository; // Dependency - zależność, relacja, asocjacja

    public NoteService(DefaultNoteRepository defaultNoteRepository) { // Injection - wstrzyknięcie zależności
        this.defaultNoteRepository = defaultNoteRepository;
    }

    public void list() {
        LOGGER.info("list()");
        defaultNoteRepository.list(); // Delegation - delegacja
        LOGGER.info("list(...) = ");
    }
}
