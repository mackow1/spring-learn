package pl.kowalczyk.maciej.spring.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.kowalczyk.maciej.spring.learn.repository.entity.AuthorEntity;
import pl.kowalczyk.maciej.spring.learn.web.model.AuthorModel;

import java.util.logging.Logger;

//@Component
@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

//    private static final Logger LOGGER = Logger.getLogger(AuthorRepository.class.getName());
//
//    public void list() {
//        LOGGER.info("list()");
//        LOGGER.info("list(...) = ");
//    }
//
//    public void create(AuthorModel authorModel) {
//        LOGGER.info("create(" + authorModel + ")");
//        LOGGER.info("create(...) = ");
//    }
}
