package ch.csbe.productmanager.resources.product.dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class ProductCreateDto {
    @NotNull
    private String name;
    @NotNull
    private Float price;
    @NotNull
    private Integer categoryId;
}

