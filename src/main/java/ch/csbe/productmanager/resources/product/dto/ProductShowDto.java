package ch.csbe.productmanager.resources.product.dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class ProductShowDto {
    @NotNull
    private Integer id;
    @NotNull
    private String name;
    private Float price;
}
