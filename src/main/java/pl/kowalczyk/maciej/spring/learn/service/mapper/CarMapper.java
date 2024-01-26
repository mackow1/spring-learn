package pl.kowalczyk.maciej.spring.learn.service.mapper;

import org.modelmapper.ModelMapper;
import pl.kowalczyk.maciej.spring.learn.repository.entity.CarEntity;
import pl.kowalczyk.maciej.spring.learn.web.model.CarModel;

import java.util.logging.Logger;

public class CarMapper {

    private static final Logger LOGGER = Logger.getLogger(CarMapper.class.getName());

    public CarModel from(CarEntity carEntity) {
        LOGGER.info("from(" + carEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        CarModel carModel = modelMapper.map(carEntity, CarModel.class);

        LOGGER.info("from(...) = " + carModel);
        return carModel;
    }

    public CarEntity from(CarModel carModel) {
        LOGGER.info("from(" + carModel + ")");

        CarEntity result = null;

        LOGGER.info("from(...) = " + result);
        return result;
    }
}
