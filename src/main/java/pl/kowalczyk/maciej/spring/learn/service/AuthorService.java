package pl.kowalczyk.maciej.spring.learn.service;

import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.spring.learn.api.exception.author.AuthorReadException;
import pl.kowalczyk.maciej.spring.learn.repository.AuthorRepository;
import pl.kowalczyk.maciej.spring.learn.repository.entity.AuthorEntity;
import pl.kowalczyk.maciej.spring.learn.service.mapper.AuthorMapper;
import pl.kowalczyk.maciej.spring.learn.web.model.AuthorModel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
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

    public AuthorModel create(AuthorModel authorModel) {
        LOGGER.info("create(" + authorModel + ")");

        AuthorEntity authorEntity = authorMapper.from(authorModel);
        AuthorEntity savedAuthorEntity = authorRepository.save(authorEntity);
        AuthorModel convertedAuthorModel = authorMapper.from(savedAuthorEntity);

        LOGGER.info("create(...) = " + authorModel);
        return convertedAuthorModel;
    }

    public AuthorModel read(Long id) throws AuthorReadException {
        LOGGER.info("read(" + id + ")");

        if (id == null) {
            throw new AuthorReadException("ID must not be NULL");
        }

        Optional<AuthorEntity> optionalAuthorEntity = authorRepository.findById(id);
        AuthorEntity authorEntity = optionalAuthorEntity.orElseThrow(
                () -> {
                    LOGGER.log(Level.SEVERE, "Author not found for given ID: " + id);
                    return new AuthorReadException("Author not found for given ID: " + id);
                }
        );

        AuthorModel authorModel = authorMapper.from(authorEntity);

        LOGGER.info("read(...) = " + authorModel);
        return authorModel;
    }
}
