package pl.kowalczyk.maciej.spring.learn.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kowalczyk.maciej.spring.learn.api.exception.apartment.ApartmentCreateException;
import pl.kowalczyk.maciej.spring.learn.repository.ApartmentRepository;
import pl.kowalczyk.maciej.spring.learn.repository.entity.ApartmentEntity;
import pl.kowalczyk.maciej.spring.learn.service.mapper.ApartmentMapper;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

@ExtendWith(MockitoExtension.class)
class ApartmentServiceSpringPureMockTest {

    @Mock
    private ApartmentRepository apartmentRepository;

    @Mock
    private ApartmentMapper apartmentMapper;

    @InjectMocks
    private ApartmentService apartmentService;

    @Test
    void create() throws ApartmentCreateException {
        // given
        ApartmentEntity apartmentEntity = new ApartmentEntity();
        apartmentEntity.setId(12L);
        apartmentEntity.setName("ABC");
        apartmentEntity.setPrice(1234);

        ApartmentModel apartmentModel = new ApartmentModel();
        apartmentModel.setId(12L);
        apartmentModel.setName("ABC");
        apartmentModel.setPrice(1234);

        // when
        Mockito.when(apartmentMapper.from(apartmentModel)).thenReturn(apartmentEntity);
        Mockito.when(apartmentRepository.save(apartmentEntity)).thenReturn(apartmentEntity);
        Mockito.when(apartmentMapper.from(apartmentEntity)).thenReturn(apartmentModel);

        ApartmentModel createdApartmentModel = apartmentService.create(apartmentModel);

        Mockito.verify(apartmentMapper, Mockito.times(1)).from(apartmentEntity);

        // then
        Assertions.assertNotNull(createdApartmentModel, "Model is NULL");
    }
}