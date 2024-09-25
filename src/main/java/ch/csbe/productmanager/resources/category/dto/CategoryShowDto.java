package ch.csbe.productmanager.resources.category.dto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * DTO zur Anzeige von Kategorien.
 */
@Data
public class CategoryShowDto {

    @NotNull
    private Integer id;

    @NotNull
    private Boolean active;

    @NotNull
    private String name;
}

