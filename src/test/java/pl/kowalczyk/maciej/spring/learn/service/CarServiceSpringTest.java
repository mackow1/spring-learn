package pl.kowalczyk.maciej.spring.learn.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.spring.learn.web.model.CarModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CarServiceSpringTest {

    @Autowired
    private CarService carService;

    public static final CarModel CAR_MODEL = new CarModel("Audi a4", 123);

    @Test
    void create() {
        // given

        // when
        CarModel savedCarEntity = carService.create(CAR_MODEL);

        // then
        Assertions.assertAll(
                () -> assertEquals(CAR_MODEL.getModelName(), savedCarEntity.getModelName(), "Model names are not equal"),
                () -> assertEquals(CAR_MODEL.getHorsePower(), savedCarEntity.getHorsePower(), "Horse power is not equal")
//                () -> assertNotNull(savedCarEntity.getId(), "Id is NULL")
        );
    }

    @Test
    void list() {
        // given

        // when
        List<CarModel> carModels = carService.list();

        // then
        Assertions.assertNotNull(carModels, "Model is NULL");
    }
}