package pl.kowalczyk.maciej.spring.learn.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.spring.learn.repository.entity.AuthorEntity;
import pl.kowalczyk.maciej.spring.learn.web.model.AuthorModel;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AuthorMapperSpringTest {

    @Autowired
    private AuthorMapper authorMapper;

    @Test
    void fromEntities() {
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
