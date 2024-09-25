package ch.csbe.productmanager.resources.product.dto;

import ch.csbe.productmanager.resources.category.dto.CategoryShowDto;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class ProductDetailDto {
    @NotNull
    private Integer id;
    @NotNull
    private String name;
    private String description;
    private Float price;
    private CategoryShowDto category;
}
