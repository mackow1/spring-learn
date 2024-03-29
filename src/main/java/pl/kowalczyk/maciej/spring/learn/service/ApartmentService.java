package pl.kowalczyk.maciej.spring.learn.service;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.spring.learn.api.exception.apartment.ApartmentCreateException;
import pl.kowalczyk.maciej.spring.learn.api.exception.apartment.ApartmentDeleteException;
import pl.kowalczyk.maciej.spring.learn.api.exception.apartment.ApartmentReadException;
import pl.kowalczyk.maciej.spring.learn.api.exception.apartment.ApartmentUpdateException;
import pl.kowalczyk.maciej.spring.learn.repository.ApartmentRepository;
import pl.kowalczyk.maciej.spring.learn.repository.entity.ApartmentEntity;
import pl.kowalczyk.maciej.spring.learn.service.mapper.ApartmentMapper;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ApartmentService {

    private static final Logger LOGGER = Logger.getLogger(ApartmentService.class.getName());

    private final ApartmentRepository apartmentRepository;
    private final ApartmentMapper apartmentMapper;

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

//        Sposób 1
//        Objects.requireNonNull(apartmentModel, "Model must not be NULL");

//        Sposób 2
        if (apartmentModel == null) {
            throw new ApartmentCreateException("Model must not be NULL");
        }

        try {
            ApartmentEntity apartmentEntity = apartmentMapper.from(apartmentModel);
            ApartmentEntity savedApartmentEntity = apartmentRepository.save(apartmentEntity);
            ApartmentModel convertedApartmentModel = apartmentMapper.from(savedApartmentEntity);

            LOGGER.info("create(...) = " + convertedApartmentModel);
            return convertedApartmentModel;
        } catch (DataIntegrityViolationException e) {
            LOGGER.log(Level.SEVERE, "Data integrity violation when saving apartment", e);
            throw new ApartmentCreateException("Data integrity violation for apartment creation.");
        } catch (OptimisticLockingFailureException e) {
            LOGGER.log(Level.SEVERE, "Optimistic locking failure for apartment", e);
            throw new ApartmentCreateException("Apartment has already been saved by another transaction.");
        }

    }

    public ApartmentModel read(Long id) throws ApartmentReadException {
        LOGGER.info("read(" + id + ")");

//        Sposób 1
//        Objects.requireNonNull(id, "ID must not be NULL");

//        Sposób 2
        if (id == null) {
            throw new ApartmentReadException("ID must not be NULL");
        }

        Optional<ApartmentEntity> optionalApartmentEntity = apartmentRepository.findById(id);
        ApartmentEntity apartmentEntity = optionalApartmentEntity.orElseThrow(
                () -> {
                    LOGGER.log(Level.SEVERE, "Apartment not found for given ID: ", id);
                    return new ApartmentReadException("Apartment not found for given ID: " + id);
                });

        ApartmentModel readApartmentModel = apartmentMapper.from(apartmentEntity);

        LOGGER.info("read(...) = " + readApartmentModel);
        return readApartmentModel;
    }

    public ApartmentModel update(ApartmentModel apartmentModel) throws ApartmentUpdateException {
        LOGGER.info("update(" + apartmentModel + ")");

//        Sposób 1
//        Objects.requireNonNull(apartmentModel, "Model must not be NULL");

//        Sposób 2
        if (apartmentModel == null) {
            throw new ApartmentUpdateException("Model must not be NULL");
        }

        ApartmentEntity apartmentEntity = apartmentMapper.from(apartmentModel);
        ApartmentEntity updatedApartmentEntity;

        try {
            updatedApartmentEntity = apartmentRepository.save(apartmentEntity);
        } catch (DataIntegrityViolationException e) {
            LOGGER.log(Level.SEVERE, "Data integrity violation when updating apartment: " + apartmentEntity, e);
            throw new ApartmentUpdateException("Data integrity violation for apartment update.");
        } catch (OptimisticLockingFailureException e) {
            LOGGER.log(Level.SEVERE, "Optimistic locking failure for apartment: " + apartmentEntity, e);
            throw new ApartmentUpdateException("Apartment has already been updated by another transaction.");
        }

        ApartmentModel updatedApartmentModel = apartmentMapper.from(updatedApartmentEntity);

        LOGGER.info("update(...) = " + updatedApartmentModel);
        return updatedApartmentModel;
    }

    public void delete(Long id) throws ApartmentDeleteException {
        LOGGER.info("delete(" + id + ")");

        try {
            apartmentRepository.deleteById(id);
        } catch (DataAccessException e) {
            LOGGER.log(Level.SEVERE, "Database access error while deleting apartment with ID: " + id, e);
            throw new ApartmentDeleteException("error while deleting apartment with ID: " + id);
        }

        LOGGER.info("delete(...) = ");
    }
}
