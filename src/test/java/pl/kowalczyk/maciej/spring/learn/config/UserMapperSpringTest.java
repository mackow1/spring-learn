package pl.kowalczyk.maciej.spring.learn.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class UserMapperSpringTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void fromEntities() {
        // given
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity());

        // when
        List<UserModel> userModels = userMapper.fromEntities(userEntities);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(userModels, "List is NULL"),
                () -> Assertions.assertEquals(userEntities.size(), userModels.size(), "Lists are not equal in sizes")
        );
    }
}