package ch.csbe.productmanager.resources.category.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * DTO zur Anzeige grundlegender Kategorieninformationen.
 */
@Data
@Schema(description = "DTO zur Anzeige grundlegender Kategorieninformationen.")
public class CategoryShowDto {

    @NotNull
    @Schema(description = "Die eindeutige ID der Kategorie.", example = "1")
    private Integer id;

    @NotNull
    @Schema(description = "Gibt an, ob die Kategorie aktiv ist.", example = "true")
    private Boolean active;

    @NotNull
    @Schema(description = "Der Name der Kategorie.", example = "Elektronik")
    private String name;
}
