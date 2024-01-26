package pl.kowalczyk.maciej.spring.learn.service.mapper;

import pl.kowalczyk.maciej.spring.learn.repository.entity.CarEntity;
import pl.kowalczyk.maciej.spring.learn.web.model.CarModel;

import java.util.logging.Logger;

public class CarMapper {

    private static final Logger LOGGER = Logger.getLogger(CarMapper.class.getName());

    public CarModel from(CarEntity carEntity) {
        LOGGER.info("from()");

        CarModel result = null;

        LOGGER.info("from(...) = " + result);
        return result;
    }
}
