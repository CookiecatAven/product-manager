package ch.csbe.productmanager.resources.category.dto;


import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * DTO für die Erstellung einer neuen Kategorie.
 */
@Data
public class CategoryCreateDto {

    @NotNull
    private Boolean active;


    @NotNull
    private String name;
}
