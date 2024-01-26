package pl.kowalczyk.maciej.spring.learn.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.kowalczyk.maciej.spring.learn.repository.entity.AuthorEntity;
import pl.kowalczyk.maciej.spring.learn.web.model.AuthorModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class AuthorMapper {

    private static final Logger LOGGER = Logger.getLogger(AuthorMapper.class.getName());

    public AuthorModel from(AuthorEntity authorEntity) {
        LOGGER.info("from(" + authorEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        AuthorModel authorModel = modelMapper.map(authorEntity, AuthorModel.class);

        LOGGER.info("from(...) = " + authorModel);
        return authorModel;
    }

    public AuthorEntity from(AuthorModel authorModel) {
        LOGGER.info("from(" + authorModel + ")");

        ModelMapper modelMapper = new ModelMapper();
        AuthorEntity authorEntity = modelMapper.map(authorModel, AuthorEntity.class);

        LOGGER.info("from(...) = " + authorEntity);
        return authorEntity;
    }

    public List<AuthorModel> fromEntities(List<AuthorEntity> authorEntities) {
        LOGGER.info("fromEntities(" + authorEntities + ")");

        List<AuthorModel> authorModels = authorEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());

        LOGGER.info("fromEntities(...) = " + authorModels);
        return authorModels;
    }
}
