package pl.kowalczyk.maciej.spring.learn.web.model;

import jakarta.validation.constraints.NotEmpty;

public class ApartmentModel {

    private Long id;

    @NotEmpty(message = "{not.empty.message}")
    private String name;
    private Integer price;

    public ApartmentModel() {
    }

    public ApartmentModel(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ApartmentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
