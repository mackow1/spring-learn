package pl.kowalczyk.maciej.spring.learn.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleRepositoryTest {
    @Autowired
    private RoleRepository roleRepository;

    @Test
    void findByName() {
        // given

        // when
//        RoleEntity foundRoleEntity = roleRepository.findByName(RoleType.ADMIN.name());
        RoleEntity foundRoleEntity = roleRepository.findByName(RoleType.ADMIN);

        // then
        Assertions.assertNotNull(foundRoleEntity, "ROLE not found");
    }

    @Test
    void createRoleAdmin() {
        // given
        RoleEntity roleEntity = new RoleEntity();
//        roleEntity.setName(RoleType.ADMIN.name());
        roleEntity.setName(RoleType.ADMIN);

        // when
        RoleEntity savedRoleEntity = roleRepository.save(roleEntity);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedRoleEntity, "Entity is NULL"),
                () -> Assertions.assertNotNull(savedRoleEntity.getId(), "Id is NULL")
        );
    }

    @Test
    void createRoleGuest() {
        // given
        RoleEntity roleEntity = new RoleEntity();
//        roleEntity.setName(RoleType.ADMIN.name());
        roleEntity.setName(RoleType.GUEST);

        // when
        RoleEntity savedRoleEntity = roleRepository.save(roleEntity);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedRoleEntity, "Entity is NULL"),
                () -> Assertions.assertNotNull(savedRoleEntity.getId(), "Id is NULL")
        );
    }
}