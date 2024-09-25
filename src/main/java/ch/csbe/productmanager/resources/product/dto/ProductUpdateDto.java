package ch.csbe.productmanager.resources.product.dto;

import lombok.Data;

@Data
public class ProductUpdateDto {
    private String name;
    private Float price;
    private Integer categoryId;
}

