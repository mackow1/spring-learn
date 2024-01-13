package pl.kowalczyk.maciej.spring.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import pl.kowalczyk.maciej.spring.learn.repository.entity.ApartmentEntity;
import pl.kowalczyk.maciej.spring.learn.service.ApartmentService;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

import java.util.logging.Logger;

@Repository
//@NoRepositoryBean
public interface ApartmentRepository extends JpaRepository<ApartmentEntity, Long> {

//    private static final Logger LOGGER = Logger.getLogger(ApartmentRepository.class.getName());

//    public void create(ApartmentModel apartmentModel) {
//        LOGGER.info("create(" + apartmentModel + ")");
//
//        LOGGER.info("create(...) = ");
//    }
}
