package pl.kowalczyk.maciej.spring.learn.web.model;

public class CarModel {

    private String modelName;
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
