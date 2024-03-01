package pl.kowalczyk.maciej.spring.learn.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositorySpringTest {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
//    @Transactional
//    @Rollback(value = false)
    void create() {
        // given
        String roleName = RoleType.ADMIN.name();
        System.out.println("#### roleName: " + roleName);
        RoleEntity foundGuestRoleEntity = roleRepository.findByName(RoleType.GUEST);
        System.out.println("#### foundGuestRoleEntity: " + foundGuestRoleEntity);

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("NowakUserEntityTest");
        userEntity.setPassword("qaz@123");
        userEntity.getRoles().add(foundGuestRoleEntity);

        // when
        UserEntity savedEntity = userRepository.save(userEntity);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedEntity, "Entity is NULL"),
                () -> Assertions.assertNotNull(savedEntity.getId(), "Id is NULL")
        );
    }

}

/*
SELECT *
FROM USERS AS U
LEFT JOIN USERS_ROLES AS UR
ON U.ID  = UR.USERS_ID
RIGHT JOIN ROLES AS R
ON R.ID = UR.ROLES_ID;
 */