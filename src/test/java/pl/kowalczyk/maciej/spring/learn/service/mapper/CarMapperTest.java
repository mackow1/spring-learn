package pl.kowalczyk.maciej.spring.learn.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.spring.learn.repository.entity.CarEntity;
import pl.kowalczyk.maciej.spring.learn.web.model.CarModel;

import static org.junit.jupiter.api.Assertions.*;

class CarMapperTest {

    public static final String MERCEDES_BENZ_C = "Mercedes-Benz C";

    @Test
    void from() {
        // given
        CarMapper carMapper = new CarMapper();
        CarEntity carEntity = new CarEntity();
        carEntity.setModelName(MERCEDES_BENZ_C);

        // when
        CarModel carModel = carMapper.from(carEntity);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(carModel, "Model is NULL"),
                () -> Assertions.assertEquals(MERCEDES_BENZ_C, carModel.getModelName(), "Names are not equal")
        );
    }

    @Test
    void testFrom() {
        // given

        // when

        // then

    }
}