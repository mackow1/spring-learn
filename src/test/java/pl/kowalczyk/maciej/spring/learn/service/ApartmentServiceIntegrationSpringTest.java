package pl.kowalczyk.maciej.spring.learn.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.spring.learn.repository.entity.ApartmentEntity;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApartmentServiceIntegrationSpringTest {

    @Autowired
    private ApartmentService apartmentService;

    @Test
    void read() {
        // given
        ApartmentModel apartmentModel = new ApartmentModel();
        apartmentModel.setName("Mieszkanie");
        apartmentModel.setPrice(111);

        // when
        ApartmentModel createdApartmentModel = apartmentService.create(apartmentModel);
        ApartmentEntity readApartmentEntity = apartmentService.read(createdApartmentModel.getId());

        // then
        Assertions.assertNotNull(readApartmentEntity, "Entity is NULL");
    }
}