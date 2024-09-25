package ch.csbe.productmanager.resources.category.dto;

import ch.csbe.productmanager.resources.product.dto.ProductShowDto;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * DTO zur Aktualisierung von Kategorien.
 */
@Data
public class CategoryDetailDto {

    @NotNull
    private Integer id;

    @NotNull
    private Boolean active;

    @NotNull
    private String name;

    @NotNull
    private List<ProductShowDto> products;
}

