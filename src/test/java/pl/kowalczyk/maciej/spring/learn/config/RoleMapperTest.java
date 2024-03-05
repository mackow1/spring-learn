package pl.kowalczyk.maciej.spring.learn.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleMapperTest {

    @Test
    void givenRoleEntity_whenFrom_thenEntityConvertedToModel() {
        // given
        RoleMapper roleMapper = new RoleMapper();

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(RoleType.ADMIN);

        // when
        RoleModel roleModel = roleMapper.from(roleEntity);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(roleModel, "Model is NULL"),
                () -> Assertions.assertEquals(roleEntity.getName(), roleModel.getName(), "Names are not equal")
        );
    }

}