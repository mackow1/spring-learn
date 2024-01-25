package pl.kowalczyk.maciej.spring.learn.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.spring.learn.web.model.AuthorModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorServiceSpringTest {

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
}