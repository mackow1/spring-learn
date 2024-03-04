package pl.kowalczyk.maciej.spring.learn.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    @Test
    void givenEntity_whenFrom_thenConvertEntityToModel() {
        // given
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("New_User_Entity_Test");
        userEntity.setPassword("1234");
        userEntity.setId(1L);

        UserMapper userMapper = new UserMapper();

        // when
        UserModel userModel = userMapper.from(userEntity);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(userModel, "Model is NULL"),
                () -> Assertions.assertNotNull(userModel.getId(), "ID is NULL")
        );
    }

    @Test
    void givenModel_whenFrom_thenConvertModelToEntity() {
        // given
        UserModel userModel = new UserModel();
        userModel.setUsername("New_User_Model_Test");
        userModel.setPassword("1234");
        userModel.setId(2L);

        UserMapper userMapper = new UserMapper();

        // when
        UserEntity userEntity = userMapper.from(userModel);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(userEntity, "Entity is NULL"),
                () -> Assertions.assertNotNull(userEntity.getId(), "ID is NULL")
        );
    }
}