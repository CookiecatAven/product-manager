package ch.csbe.productmanager.resources.product.dto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class ProductCreateDto {

    @NotNull
    private Boolean active;

    @NotNull
    private String sku;

    @NotNull
    private String name;

    @NotNull
    private String image;

    @NotNull
    private String description;

    @NotNull
    private Float price;

    @NotNull
    private Integer stock;
}

