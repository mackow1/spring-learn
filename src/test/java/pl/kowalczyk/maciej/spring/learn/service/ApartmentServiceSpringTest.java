package pl.kowalczyk.maciej.spring.learn.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import pl.kowalczyk.maciej.spring.learn.api.exception.apartment.ApartmentCreateException;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApartmentServiceSpringTest {

    public static final String DATA_INTEGRITY_EXCEPTION_TEST_APARTMENT_NAME = "DataIntegrityExceptionTest";
    @Autowired
    private ApartmentService apartmentService;

    @Test
    void create() throws ApartmentCreateException {
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


    // Mockowanie?
    @Test
    @Transactional
    @Rollback
    void givenTwoModels_whenCreate_thenThrowsDataIntegrityViolationException() throws ApartmentCreateException {
        // given
        ApartmentModel apartmentModel1 = new ApartmentModel();
        apartmentModel1.setId(112233L);
        apartmentModel1.setName(DATA_INTEGRITY_EXCEPTION_TEST_APARTMENT_NAME);

        ApartmentModel apartmentModel2 = new ApartmentModel();
        apartmentModel2.setId(112233L);
        apartmentModel2.setName(DATA_INTEGRITY_EXCEPTION_TEST_APARTMENT_NAME);

        // when
        // then
        Assertions.assertThrows(DataIntegrityViolationException.class,
                () -> {
                    apartmentService.create(apartmentModel1);
                    apartmentService.create(apartmentModel2);
                }
        );
    }
}