package pl.kowalczyk.maciej.spring.learn.service;

import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.spring.learn.repository.CarRepository;
import pl.kowalczyk.maciej.spring.learn.repository.entity.CarEntity;
import pl.kowalczyk.maciej.spring.learn.web.model.CarModel;

import java.util.logging.Logger;

@Service
public class CarService {

    private static final Logger LOGGER = Logger.getLogger(CarService.class.getName());

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void list() {
        LOGGER.info("list()");
        LOGGER.info("list(...) = ");
    }

    public CarEntity create(CarModel carModel) {
        LOGGER.info("create(" + carModel + ")");

        CarEntity carEntity = convertToEntity(carModel);

        LOGGER.info("create(...) = " + carEntity);
        return carRepository.save(carEntity);
    }

    private CarEntity convertToEntity(CarModel carModel) {
        CarEntity carEntity = new CarEntity();
        carEntity.setModelName(carModel.getModelName());
        carEntity.setHorsePower(carModel.getHorsePower());

        return carEntity;
    }
}
