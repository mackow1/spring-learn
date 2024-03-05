package pl.kowalczyk.maciej.spring.learn.config;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class RoleMapper {

    private static final Logger LOGGER = Logger.getLogger(RoleMapper.class.getName());

    public RoleEntity from(RoleModel roleModel) {
        LOGGER.info("from(" + roleModel + ")");

        ModelMapper modelMapper = new ModelMapper();
        RoleEntity roleEntity = modelMapper.map(roleModel, RoleEntity.class);

        LOGGER.info("from(...) = " + roleEntity);
        return roleEntity;
    }

    public RoleModel from(RoleEntity roleEntity) {
        LOGGER.info("from(" + roleEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        RoleModel roleModel = modelMapper.map(roleEntity, RoleModel.class);

        LOGGER.info("from(...) = " + roleModel);
        return roleModel;
    }

    public List<RoleModel> fromEntities(List<RoleEntity> usersEntities) {
        LOGGER.info("fromEntities()");

        List<RoleModel> collectedRoles = usersEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());

        LOGGER.info("fromEntities(...) = " + collectedRoles);
        return collectedRoles;
    }
}
