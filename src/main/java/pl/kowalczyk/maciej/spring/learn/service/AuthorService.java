package pl.kowalczyk.maciej.spring.learn.service;

import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.spring.learn.repository.AuthorRepository;
import pl.kowalczyk.maciej.spring.learn.repository.entity.AuthorEntity;
import pl.kowalczyk.maciej.spring.learn.web.model.AuthorModel;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AuthorService {

    private static final Logger LOGGER = Logger.getLogger(AuthorService.class.getName());

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorModel> list() {
        LOGGER.info("list()");

        List<AuthorEntity> authorEntities = authorRepository.findAll();
        List<AuthorModel> authorModels = null;

        LOGGER.info("list(...) = ");
        return authorModels;
    }

    public void create(AuthorModel authorModel) {
        LOGGER.info("create(" + authorModel + ")");
//        authorRepository.create(authorModel);
        LOGGER.info("create(...) = ");
    }
}
