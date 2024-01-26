package pl.kowalczyk.maciej.spring.learn.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApartmentServiceSpringTest {

    @Autowired
    private ApartmentService apartmentService;

    @Test
    void create() {
        // given
        ApartmentModel apartmentModel = new ApartmentModel();
        apartmentModel.setName("Apartemnt");
        apartmentModel.setPrice(1234);

        // when
        ApartmentModel createdApartmentModel = apartmentService.create(apartmentModel);

        // then
        Assertions.assertAll(
                () -> assertNotNull(createdApartmentModel, "Model is NULL"),
                () -> assertNotNull(createdApartmentModel.getId(), "Id is NULL")
        );
    }


}