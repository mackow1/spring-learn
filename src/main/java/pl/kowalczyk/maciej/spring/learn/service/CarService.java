package pl.kowalczyk.maciej.spring.learn.service;

import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.spring.learn.repository.CarRepository;
import pl.kowalczyk.maciej.spring.learn.repository.entity.CarEntity;
import pl.kowalczyk.maciej.spring.learn.service.mapper.CarMapper;
import pl.kowalczyk.maciej.spring.learn.web.model.CarModel;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CarService {

    private static final Logger LOGGER = Logger.getLogger(CarService.class.getName());

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarService(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public List<CarModel> list() {
        LOGGER.info("list()");

        List<CarEntity> carEntities = carRepository.findAll();
        List<CarModel> carModels = carMapper.fromEntities(carEntities);

        LOGGER.info("list(...) = " + carModels);
        return carModels;
    }

    public CarModel create(CarModel carModel) {
        LOGGER.info("create(" + carModel + ")");

        CarEntity carEntity = carMapper.from(carModel);
        CarEntity savedCarEntity = carRepository.save(carEntity);
        CarModel converterdCarModel = carMapper.from(savedCarEntity);

        LOGGER.info("create(...) = " + converterdCarModel);
        return converterdCarModel;
    }
}
