package pl.kowalczyk.maciej.spring.learn.config;

import org.modelmapper.ModelMapper;

import java.util.logging.Logger;

public class UserMapper {

    private static final Logger LOGGER = Logger.getLogger(UserMapper.class.getName());

    public UserModel from(UserEntity userEntity) {
        LOGGER.info("from(" + userEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        UserModel userModel = modelMapper.map(userEntity, UserModel.class);

        LOGGER.info("from(...) = " + userModel);
        return userModel;
    }

    public UserEntity from(UserModel userModel) {
        LOGGER.info("from(" + userModel + ")");

        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map(userModel, UserEntity.class);

        LOGGER.info("from(...) = " + userEntity);
        return userEntity;
    }
}
