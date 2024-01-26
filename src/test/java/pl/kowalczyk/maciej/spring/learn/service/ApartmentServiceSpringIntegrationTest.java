package pl.kowalczyk.maciej.spring.learn.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApartmentServiceSpringIntegrationTest {

    @Autowired
    private ApartmentService apartmentService;

    @Test
    void list() {
        // given

        // when
        List<ApartmentModel> apartments = apartmentService.list();

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(apartments, "List is NULL")
        );
    }
}