package pl.kowalczyk.maciej.spring.learn.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.kowalczyk.maciej.spring.learn.repository.entity.ApartmentEntity;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

import java.util.logging.Logger;

@Component
public class ApartmentMapper {

    private static final Logger LOGGER = Logger.getLogger(ApartmentMapper.class.getName());

    public ApartmentModel convertToModel(ApartmentEntity apartmentEntity) {
        LOGGER.info("convertToModel(" + apartmentEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        ApartmentModel apartmentModel = modelMapper.map(apartmentEntity, ApartmentModel.class);

//        ApartmentModel apartmentModel = new ApartmentModel();
//        apartmentModel.setId(apartmentEntity.getId());
//        apartmentModel.setName(apartmentEntity.getName());

        LOGGER.info("convertToModel(...) = " + apartmentModel);
        return apartmentModel;
    }

    public ApartmentEntity convertToEntity(ApartmentModel apartmentModel) {
        LOGGER.info("convertToEntity(" + apartmentModel + ")");


        ApartmentEntity apartmentEntity = new ApartmentEntity();
        apartmentEntity.setName(apartmentModel.getName());
        apartmentEntity.setPrice(apartmentModel.getPrice());

        LOGGER.info("convertToEntity(...) = " + apartmentEntity);
        return apartmentEntity;
    }
}
