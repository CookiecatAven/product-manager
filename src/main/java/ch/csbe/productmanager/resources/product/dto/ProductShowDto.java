package ch.csbe.productmanager.resources.product.dto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class ProductShowDto {

    @NotNull
    private Integer id;

    @NotNull
    private Boolean active;

    @NotNull
    private String name;

    @NotNull
    private Float price;

    @NotNull
    private Integer stock;
}
