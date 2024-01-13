package pl.kowalczyk.maciej.spring.learn.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CARS")
public class CarEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String modelName;
    private Integer horsePower;

    public CarEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", horsePower=" + horsePower +
                '}';
    }
}
