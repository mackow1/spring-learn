package pl.kowalczyk.maciej.spring.learn.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.kowalczyk.maciej.spring.learn.repository.entity.ApartmentEntity;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class ApartmentMapper {

    private static final Logger LOGGER = Logger.getLogger(ApartmentMapper.class.getName());

    public ApartmentModel from(ApartmentEntity apartmentEntity) {
        LOGGER.info("from(" + apartmentEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        ApartmentModel apartmentModel = modelMapper.map(apartmentEntity, ApartmentModel.class);

//        ApartmentModel apartmentModel = new ApartmentModel();
//        apartmentModel.setId(apartmentEntity.getId());
//        apartmentModel.setName(apartmentEntity.getName());

        LOGGER.info("from(...) = " + apartmentModel);
        return apartmentModel;
    }

    public ApartmentEntity from(ApartmentModel apartmentModel) {
        LOGGER.info("from(" + apartmentModel + ")");


        ApartmentEntity apartmentEntity = new ApartmentEntity();
        apartmentEntity.setName(apartmentModel.getName());
        apartmentEntity.setPrice(apartmentModel.getPrice());

        LOGGER.info("from(...) = " + apartmentEntity);
        return apartmentEntity;
    }

    public List<ApartmentModel> fromEntities(List<ApartmentEntity> apartmentEntities) {
        LOGGER.info("fromEntities(" + apartmentEntities + ")");

        List<ApartmentModel> apartmentModels = apartmentEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());

        LOGGER.info("fromEntities(...) = " + apartmentModels);
        return apartmentModels;
    }

    public List<ApartmentEntity> fromModels(List<ApartmentModel> apartmentModels) {
        return null;
    }
}
