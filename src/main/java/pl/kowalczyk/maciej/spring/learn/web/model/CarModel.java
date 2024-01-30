package pl.kowalczyk.maciej.spring.learn.web.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CarModel {

    @NotEmpty
    private String modelName;

    @NotNull(message = "pole musi mieć wartość")
    @Min(message = "pole musi mieć wartość minimalną 1", value = 1)
    private Integer horsePower;

    public CarModel() {
    }

    public CarModel(String modelName, Integer horsePower) {
        this.modelName = modelName;
        this.horsePower = horsePower;
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
        return "CarModel{" +
                "modelName='" + modelName + '\'' +
                ", horsePower=" + horsePower +
                '}';
    }
}
