package pl.kowalczyk.maciej.spring.learn.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.spring.learn.repository.entity.ApartmentEntity;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApartmentMapperSpringTest {

    @Autowired
    private ApartmentMapper apartmentMapper;

    @Test
    void fromEntities() {
        // given
        List<ApartmentEntity> apartmentEntities = new ArrayList<>();
        apartmentEntities.add(new ApartmentEntity());

        // when
        List<ApartmentModel> apartmentModels = apartmentMapper.fromEntities(apartmentEntities);

        // then
       Assertions.assertAll(
               () -> Assertions.assertNotNull(apartmentModels, "List is NULL"),
               () -> Assertions.assertEquals(apartmentEntities.size(), apartmentModels.size(), "Lists have different sizes")
       );
    }
}