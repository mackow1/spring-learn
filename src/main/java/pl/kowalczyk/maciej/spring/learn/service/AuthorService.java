package pl.kowalczyk.maciej.spring.learn.service;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.spring.learn.api.exception.author.AuthorDeleteException;
import pl.kowalczyk.maciej.spring.learn.api.exception.author.AuthorReadException;
import pl.kowalczyk.maciej.spring.learn.api.exception.author.AuthorUpdateException;
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

    public AuthorModel update(AuthorModel authorModel) throws AuthorUpdateException {
        LOGGER.info("update(" + authorModel + ")");

        AuthorEntity authorEntity = authorMapper.from(authorModel);
        AuthorEntity updatedAuthorEntity;

        try {
            updatedAuthorEntity = authorRepository.save(authorEntity);
        } catch (DataIntegrityViolationException e) {
            LOGGER.log(Level.SEVERE, "Data integrity violation when updating author: " + authorEntity, e);
            throw new AuthorUpdateException("Data integrity violation for author update.");
        } catch (OptimisticLockingFailureException e) {
            LOGGER.log(Level.SEVERE, "Optimistic locking failure for author: " + authorEntity, e);
            throw new AuthorUpdateException("Author has already been updated by another transaction.");
        }

        AuthorModel result = authorMapper.from(updatedAuthorEntity);

        LOGGER.info("update(...) = " + result);
        return result;
    }

    public void delete(Long id) throws AuthorDeleteException {
        LOGGER.info("delete(" + id + ")");

        if (id == null) {
            throw new AuthorDeleteException("ID must not be null");
        }

        try {
            authorRepository.deleteById(id);
        } catch (DataAccessException e) {
            LOGGER.log(Level.SEVERE, "Database access error while deleting apartment with ID: " + id, e);
            throw new AuthorDeleteException("error while deleting apartment with ID: " + id);
        }

        LOGGER.info("delete(...) = ");
    }
}
