package ch.csbe.productmanager.resources.category.dto;

import ch.csbe.productmanager.resources.product.dto.ProductShowDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * DTO zur Anzeige detaillierter Kategorieninformationen.
 */
@Data
@Schema(description = "DTO zur Anzeige detaillierter Informationen einer Kategorie.")
public class CategoryDetailDto {

    @NotNull
    @Schema(description = "Die eindeutige ID der Kategorie.", example = "1")
    private Integer id;

    @NotNull
    @Schema(description = "Gibt an, ob die Kategorie aktiv ist.", example = "true")
    private Boolean active;

    @NotNull
    @Schema(description = "Der Name der Kategorie.", example = "Elektronik")
    private String name;

    @NotNull
    @Schema(description = "Die Liste der zu dieser Kategorie gehörenden Produkte.")
    private List<ProductShowDto> products;
}

