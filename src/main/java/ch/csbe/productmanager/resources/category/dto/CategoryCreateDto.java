package ch.csbe.productmanager.resources.category.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * DTO für die Erstellung einer neuen Kategorie.
 */
@Data
@Schema(description = "DTO zur Erstellung einer neuen Kategorie.")
public class CategoryCreateDto {

    @NotNull
    @Schema(description = "Gibt an, ob die Kategorie aktiv ist.", example = "true")
    private Boolean active;

    @NotNull
    @Schema(description = "Der Name der Kategorie.", example = "Elektronik")
    private String name;
}
