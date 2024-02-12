package pl.kowalczyk.maciej.spring.learn.service;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.spring.learn.api.exception.apartment.ApartmentCreateException;
import pl.kowalczyk.maciej.spring.learn.api.exception.apartment.ApartmentDeleteException;
import pl.kowalczyk.maciej.spring.learn.api.exception.apartment.ApartmentReadException;
import pl.kowalczyk.maciej.spring.learn.api.exception.apartment.ApartmentUpdateException;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

@SpringBootTest
class ApartmentServiceIntegrationSpringTest {

    public static final String SERVICE_UPDATE_INTEGRATION_TEST_UPDATED_NAME = "ServiceUpdateIntegrationTest-updated";
    @Autowired
    private ApartmentService apartmentService;

    @Test
    void read() throws ApartmentCreateException, ApartmentReadException {
        // given
        ApartmentModel apartmentModel = new ApartmentModel();
        apartmentModel.setName("Mieszkanie");
        apartmentModel.setPrice(111);

        // when
        ApartmentModel createdApartmentModel = apartmentService.create(apartmentModel);
        ApartmentModel readApartmentModel = apartmentService.read(createdApartmentModel.getId());

        // then
        Assertions.assertNotNull(readApartmentModel, "Model is NULL");
    }

    @Test
    void update() throws ApartmentCreateException, ApartmentReadException, ApartmentUpdateException {
        // given
        ApartmentModel apartmentModel = new ApartmentModel();
        apartmentModel.setName("ServiceUpdateIntegrationTest");
        apartmentModel.setPrice(1122);

        // when
        ApartmentModel createdApartmentModel = apartmentService.create(apartmentModel);
        ApartmentModel readApartmentModel = apartmentService.read(createdApartmentModel.getId());

        readApartmentModel.setName(SERVICE_UPDATE_INTEGRATION_TEST_UPDATED_NAME);
        readApartmentModel.setPrice(1120);

        ApartmentModel updatedApartmentModel = apartmentService.update(readApartmentModel);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(updatedApartmentModel, "Model is NULL"),
                () -> Assertions.assertEquals(createdApartmentModel.getId(), updatedApartmentModel.getId(), "IDs are not equal"),
                () -> Assertions.assertEquals(SERVICE_UPDATE_INTEGRATION_TEST_UPDATED_NAME, updatedApartmentModel.getName(), "Names are not equal")
        );
    }

    @Test
    void delete() throws ApartmentCreateException, ApartmentDeleteException {
        // given
        ApartmentModel apartmentModel = new ApartmentModel();
        apartmentModel.setName("ServiceDeleteIntegrationTest");
        apartmentModel.setPrice(1133);

        // when
        ApartmentModel createdApartmentModel = apartmentService.create(apartmentModel);
        long id = createdApartmentModel.getId();

        apartmentService.delete(id);

        // then
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            apartmentService.read(id);
        });
    }
}