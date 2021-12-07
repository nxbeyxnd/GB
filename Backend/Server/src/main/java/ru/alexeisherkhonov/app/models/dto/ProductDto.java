package ru.alexeisherkhonov.app.models.dto;

import lombok.Data;
import ru.alexeisherkhonov.app.models.entities.Product;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private int cost;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.cost = product.getCost();
    }
}
