package ch.csbe.productmanager.resources.category.dto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * DTO zur Aktualisierung von Kategorien.
 */
@Data
public class CategoryUpdateDto {

    @NotNull
    private Integer id;

    @NotNull
    private Boolean active;

    @NotNull
    private String name;
}

