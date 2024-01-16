package pl.kowalczyk.maciej.spring.learn.service;

import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.spring.learn.repository.ApartmentRepository;
import pl.kowalczyk.maciej.spring.learn.repository.entity.ApartmentEntity;
import pl.kowalczyk.maciej.spring.learn.service.mapper.ApartmentMapper;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ApartmentService {

    private static final Logger LOGGER = Logger.getLogger(ApartmentService.class.getName());

    private final ApartmentRepository apartmentRepository;
    private final ApartmentMapper apartmentMapper;
//    private final ModelMapper modelMapper;

    public ApartmentService(ApartmentRepository apartmentRepository, ApartmentMapper apartmentMapper) {
        this.apartmentRepository = apartmentRepository;
        this.apartmentMapper = apartmentMapper;
    }

    public List<ApartmentModel> list() {
        LOGGER.info("list()");

        List<ApartmentEntity> apartmentEntities = apartmentRepository.findAll();


        LOGGER.info("list(...) = ");
        return null;
    }

    public ApartmentModel create(ApartmentModel apartmentModel) {
        LOGGER.info("create(" + apartmentModel + ")");

        ApartmentEntity apartmentEntity = apartmentMapper.convertToEntity(apartmentModel);
        ApartmentEntity savedApartmentEntity = apartmentRepository.save(apartmentEntity);
        ApartmentModel convertedApartmentModel = apartmentMapper.convertToModel(savedApartmentEntity);

//        ApartmentEntity apartmentEntity = modelMapper.map(apartmentModel, ApartmentEntity.class);
//        ApartmentEntity savedApartmentEntity = apartmentRepository.save(apartmentEntity);
//        ApartmentModel convertedApartmentModel = modelMapper.map(savedApartmentEntity, ApartmentModel.class);

        LOGGER.info("create(...) = " + convertedApartmentModel);
        return convertedApartmentModel;
    }

    public ApartmentEntity read(ApartmentModel apartmentModel) {
        LOGGER.info("read()");

        LOGGER.info("read(...) = ");
//        return apartmentRepository.findById();
        return null;
    }

//
}
