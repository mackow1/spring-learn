package pl.kowalczyk.maciej.spring.learn.config;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;

    @ManyToMany
    private Set<RoleEntity> roles = new HashSet<>();

    public UserEntity() {
    }

    public void add(RoleEntity roleEntity) {
        roleEntity.getUsers().add(this);
        roles.add(roleEntity);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
