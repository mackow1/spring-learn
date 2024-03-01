package pl.kowalczyk.maciej.spring.learn.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
//    RoleEntity findByName(String name);
    RoleEntity findByName(RoleType name);
}
