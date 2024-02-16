package pl.kowalczyk.maciej.spring.learn.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import pl.kowalczyk.maciej.spring.learn.web.model.AuthorModel;

import java.util.List;

@SpringBootTest
class AuthorServiceSpringTest {

    public static final String CREATE_TEST_FIRST_NAME = "CreateTestFirstName";
    public static final String CREATE_TEST_LAST_NAME = "CreateTestLastName";
    @Autowired
    private AuthorService authorService;

    @Test
    void list() {
        // given

        // when
        List<AuthorModel> authorModelList = authorService.list();

        // then
        Assertions.assertNotNull(authorModelList, "List is NULL");
    }

    @Test
    @Transactional
    @Rollback
    void create() {
        // given
        AuthorModel authorModel = new AuthorModel();
        authorModel.setFirstName(CREATE_TEST_FIRST_NAME);
        authorModel.setLastName(CREATE_TEST_LAST_NAME);

        // when
        AuthorModel createdAuthorModel = authorService.create(authorModel);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(createdAuthorModel, "Model is NULL"),
                () -> Assertions.assertNotNull(createdAuthorModel.getId(), "ID is NULL"),
                () -> Assertions.assertEquals(CREATE_TEST_FIRST_NAME, createdAuthorModel.getFirstName(), "Names are not equal"),
                () -> Assertions.assertEquals(CREATE_TEST_LAST_NAME, createdAuthorModel.getLastName(), "Names are not equal")
        );
    }
}