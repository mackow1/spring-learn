package pl.kowalczyk.maciej.spring.learn.service;

import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.spring.learn.repository.AuthorRepository;
import pl.kowalczyk.maciej.spring.learn.repository.entity.AuthorEntity;
import pl.kowalczyk.maciej.spring.learn.service.mapper.AuthorMapper;
import pl.kowalczyk.maciej.spring.learn.web.model.AuthorModel;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AuthorService {

    private static final Logger LOGGER = Logger.getLogger(AuthorService.class.getName());

    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public List<AuthorModel> list() {
        LOGGER.info("list()");

        List<AuthorEntity> authorEntities = authorRepository.findAll();
        List<AuthorModel> authorModels = authorMapper.fromEntities(authorEntities);

        LOGGER.info("list(...) = ");
        return authorModels;
    }

    public void create(AuthorModel authorModel) {
        LOGGER.info("create(" + authorModel + ")");
//        authorRepository.create(authorModel);
        LOGGER.info("create(...) = ");
    }
}
