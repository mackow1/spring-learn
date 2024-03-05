package pl.kowalczyk.maciej.spring.learn.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleServiceSpringTest {

    @Autowired
    private RoleService roleService;

    @Test
    void list() {
        // given

        // when
        List<RoleModel> roleModels = roleService.list();

        // then
        Assertions.assertNotNull(roleModels, "List is empty");
    }
}