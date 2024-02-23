package pl.kowalczyk.maciej.spring.learn.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.kowalczyk.maciej.spring.learn.api.exception.apartment.ApartmentCreateException;
import pl.kowalczyk.maciej.spring.learn.repository.ApartmentRepository;
import pl.kowalczyk.maciej.spring.learn.service.mapper.ApartmentMapper;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ApartmentServiceSpringMockTest {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private ApartmentMapper apartmentMapper;

    @MockBean
    private ApartmentService apartmentService;

    @Test
    void create() throws ApartmentCreateException {
        // given
        ApartmentModel apartmentModel = new ApartmentModel();
        apartmentModel.setName("Mariott");
        apartmentModel.setPrice(1234);

        // when
        Mockito.when(apartmentService.create(apartmentModel)).thenReturn(apartmentModel);
        ApartmentModel createdApartmentModel = apartmentService.create(apartmentModel);

        // then
        Assertions.assertNotNull(createdApartmentModel, "Model is NULL");
    }
}