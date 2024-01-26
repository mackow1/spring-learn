package pl.kowalczyk.maciej.spring.learn.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.spring.learn.repository.entity.CarEntity;
import pl.kowalczyk.maciej.spring.learn.web.model.CarModel;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarMapperSpringTest {

    @Autowired
    private CarMapper carMapper;

    @Test
    void fromEntities() {
        // given
        List<CarEntity> carEntities = new ArrayList<>();
        carEntities.add(new CarEntity());

        // when
        List<CarModel> carModels = carMapper.fromEntities(carEntities);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(carModels, "List is NULL"),
                () -> Assertions.assertEquals(carEntities.size(), carModels.size(), "Lists size are not equal")
        );
    }


    @Test
    void fromModels() {
        // given

        // when

        // then

    }
}
