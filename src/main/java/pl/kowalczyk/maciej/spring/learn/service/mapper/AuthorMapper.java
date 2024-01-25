package pl.kowalczyk.maciej.spring.learn.service.mapper;

import org.modelmapper.ModelMapper;
import pl.kowalczyk.maciej.spring.learn.repository.entity.AuthorEntity;
import pl.kowalczyk.maciej.spring.learn.web.model.AuthorModel;

import java.util.logging.Logger;

public class AuthorMapper {

    private static final Logger LOGGER = Logger.getLogger(AuthorMapper.class.getName());

    public AuthorModel from(AuthorEntity authorEntity) {
        LOGGER.info("from(" + authorEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        AuthorModel authorModel = modelMapper.map(authorEntity, AuthorModel.class);

        LOGGER.info("from(...) = " + authorModel);
        return authorModel;
    }
}
