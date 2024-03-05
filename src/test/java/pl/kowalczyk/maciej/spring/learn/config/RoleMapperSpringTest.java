package pl.kowalczyk.maciej.spring.learn.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RoleMapperSpringTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    void fromEntities() {
        // given
        List<RoleEntity> roleEntities = new ArrayList<>();
        roleEntities.add(new RoleEntity());

        // when
        List<RoleModel> roleModels = roleMapper.fromEntities(roleEntities);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(roleModels, "List is NULL"),
                () -> Assertions.assertEquals(roleEntities.size(), roleModels.size(), "Lists sizes are not euqal")
        );
    }
}