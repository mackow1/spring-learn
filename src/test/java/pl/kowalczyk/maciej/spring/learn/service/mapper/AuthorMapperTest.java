package pl.kowalczyk.maciej.spring.learn.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.spring.learn.repository.entity.AuthorEntity;
import pl.kowalczyk.maciej.spring.learn.web.model.AuthorModel;

import java.util.ArrayList;
import java.util.List;

class AuthorMapperTest {

    public static final String AUTHOR_NAME_MACIEJ = "Maciej";

    @Test
    void givenMapperAndEntity_whenMapperFrom_thenModelIsNotNullAndNamesAreEqual() {
        // given
        AuthorMapper authorMapper = new AuthorMapper();
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setFirstName(AUTHOR_NAME_MACIEJ);
        authorEntity.setLastName("Kowalczyk");

        // when
        AuthorModel authorModel = authorMapper.from(authorEntity);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(authorModel, "Model is NULL"),
                () -> Assertions.assertEquals(AUTHOR_NAME_MACIEJ, authorModel.getFirstName(), "Names are not equal")
        );
    }

    @Test
    void givenMapperAndModel_whenMapperFrom_thenEntityNotNullAndNamesAreEqual() {
        // given
        AuthorMapper authorMapper = new AuthorMapper();
        AuthorModel authorModel = new AuthorModel();
        authorModel.setFirstName(AUTHOR_NAME_MACIEJ);

        // when
        AuthorEntity authorEntity = authorMapper.from(authorModel);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(authorEntity, "Entity is NULL"),
                () -> Assertions.assertEquals(AUTHOR_NAME_MACIEJ, authorEntity.getFirstName(), "Names are not equal")
        );
    }

    @Test
    void givenfromEntities() {
        // given
        AuthorMapper authorMapper = new AuthorMapper();
        List<AuthorEntity> authorEntities = new ArrayList<>();
        authorEntities.add(new AuthorEntity());

        // when
        List<AuthorModel> authorModels = authorMapper.fromEntities(authorEntities);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(authorMapper, "List is NULL"),
                () -> Assertions.assertEquals(authorEntities.size(), authorModels.size(), "Lists are not equal in length")
        );
    }
}