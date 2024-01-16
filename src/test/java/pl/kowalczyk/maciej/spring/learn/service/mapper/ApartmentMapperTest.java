package pl.kowalczyk.maciej.spring.learn.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.spring.learn.repository.entity.ApartmentEntity;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

class ApartmentMapperTest {


    public static final String APARTMENT_NAME_EAGLE = "eagle";

    @Test
    void convertToModel() {
        // given
        ApartmentMapper apartmentMapper = new ApartmentMapper();
        ApartmentEntity apartmentEntity = new ApartmentEntity();
        apartmentEntity.setName(APARTMENT_NAME_EAGLE);
        apartmentEntity.setPrice(1234);

        // when
        ApartmentModel apartmentModel = apartmentMapper.convertToModel(apartmentEntity);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(apartmentModel, "Model is NULL"),
                () -> Assertions.assertEquals(APARTMENT_NAME_EAGLE, apartmentModel.getName(), "Names are not equal")
        );
    }

    @Test
    void convertToEntity() {
    }
}