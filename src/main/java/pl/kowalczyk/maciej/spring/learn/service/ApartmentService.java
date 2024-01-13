package pl.kowalczyk.maciej.spring.learn.service;

import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.spring.learn.repository.ApartmentRepository;
import pl.kowalczyk.maciej.spring.learn.repository.entity.ApartmentEntity;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

import java.util.logging.Logger;

@Service
public class ApartmentService {

    private static final Logger LOGGER = Logger.getLogger(ApartmentService.class.getName());

    private final ApartmentRepository apartmentRepository;

    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    public ApartmentModel create(ApartmentModel apartmentModel) {
        LOGGER.info("create(" + apartmentModel + ")");

        ApartmentEntity apartmentEntity = convertToEntity(apartmentModel);
        ApartmentEntity savedApartmentEntity = apartmentRepository.save(apartmentEntity);
        ApartmentModel convertedApartmentModel = convertToModel(savedApartmentEntity);

        LOGGER.info("create(...) = " + convertedApartmentModel);
        return convertedApartmentModel;
    }

    public ApartmentEntity read(ApartmentModel apartmentModel) {
        LOGGER.info("read()");

        LOGGER.info("read(...) = ");
//        return apartmentRepository.findById();
        return null;
    }

    private ApartmentModel convertToModel(ApartmentEntity apartmentEntity) {
        LOGGER.info("convertToModel(" + apartmentEntity + ")");

        ApartmentModel apartmentModel = new ApartmentModel();
        apartmentModel.setId(apartmentEntity.getId());
        apartmentModel.setName(apartmentEntity.getName());

        LOGGER.info("convertToModel(...) = " + apartmentModel);
        return apartmentModel;
    }

    private ApartmentEntity convertToEntity(ApartmentModel apartmentModel) {
        ApartmentEntity apartmentEntity = new ApartmentEntity();
        apartmentEntity.setName(apartmentModel.getName());
        apartmentEntity.setPrice(apartmentModel.getPrice());

        return apartmentEntity;
    }
}
