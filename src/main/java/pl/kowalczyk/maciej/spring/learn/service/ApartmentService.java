package pl.kowalczyk.maciej.spring.learn.service;

import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.spring.learn.api.exception.ApartmentCreateException;
import pl.kowalczyk.maciej.spring.learn.api.exception.ApartmentDeleteException;
import pl.kowalczyk.maciej.spring.learn.api.exception.ApartmentReadException;
import pl.kowalczyk.maciej.spring.learn.api.exception.ApartmentUpdateException;
import pl.kowalczyk.maciej.spring.learn.repository.ApartmentRepository;
import pl.kowalczyk.maciej.spring.learn.repository.entity.ApartmentEntity;
import pl.kowalczyk.maciej.spring.learn.service.mapper.ApartmentMapper;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

import java.util.List;
import java.util.Optional;
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
        List<ApartmentModel> apartmentModels = apartmentMapper.fromEntities(apartmentEntities);

        LOGGER.info("list(...) = " + apartmentModels);
        return apartmentModels;
    }

    public ApartmentModel create(ApartmentModel apartmentModel) throws ApartmentCreateException {
        LOGGER.info("create(" + apartmentModel + ")");

        ApartmentEntity apartmentEntity = apartmentMapper.from(apartmentModel);
        ApartmentEntity savedApartmentEntity = apartmentRepository.save(apartmentEntity);
        ApartmentModel convertedApartmentModel = apartmentMapper.from(savedApartmentEntity);

//        ApartmentEntity apartmentEntity = modelMapper.map(apartmentModel, ApartmentEntity.class);
//        ApartmentEntity savedApartmentEntity = apartmentRepository.save(apartmentEntity);
//        ApartmentModel convertedApartmentModel = modelMapper.map(savedApartmentEntity, ApartmentModel.class);

        LOGGER.info("create(...) = " + convertedApartmentModel);
        return convertedApartmentModel;
    }

    public ApartmentModel read(Long id) throws ApartmentReadException {
        LOGGER.info("read(" + id + ")");

        Optional<ApartmentEntity> optionalApartmentEntity = apartmentRepository.findById(id);
        ApartmentEntity apartmentEntity = optionalApartmentEntity.orElseThrow(
                () -> new ApartmentReadException("Apartment not found for given id: " + id));
        ApartmentModel readApartmentModel = apartmentMapper.from(apartmentEntity);

        LOGGER.info("read(...) = " + readApartmentModel);
        return readApartmentModel;
    }

    public ApartmentModel update(ApartmentModel apartmentModel) throws ApartmentUpdateException {
        LOGGER.info("update()");

        ApartmentEntity apartmentEntity = apartmentMapper.from(apartmentModel);
        ApartmentEntity updatedApartmentEntity = apartmentRepository.save(apartmentEntity);
        ApartmentModel updatedApartmentModel = apartmentMapper.from(updatedApartmentEntity);

        LOGGER.info("update(...) = " + updatedApartmentModel);
        return updatedApartmentModel;
    }

    public void delete(Long id) throws ApartmentDeleteException {
        LOGGER.info("delete()");

        apartmentRepository.deleteById(id);

        LOGGER.info("delete(...) = ");
    }
//
}
