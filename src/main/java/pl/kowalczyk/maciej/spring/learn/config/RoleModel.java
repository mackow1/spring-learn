package pl.kowalczyk.maciej.spring.learn.config;

public class RoleModel {

    private Long id;
    private RoleType name;

    public RoleModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleType getName() {
        return name;
    }

    public void setName(RoleType name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleModel{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
