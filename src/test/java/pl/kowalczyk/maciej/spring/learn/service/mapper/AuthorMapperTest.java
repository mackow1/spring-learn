package pl.kowalczyk.maciej.spring.learn.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.spring.learn.repository.entity.AuthorEntity;
import pl.kowalczyk.maciej.spring.learn.web.model.AuthorModel;

class AuthorMapperTest {

    public static final String AUTHOR_NAME_MACIEJ = "Maciej";

    @Test
    void from() {
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
}