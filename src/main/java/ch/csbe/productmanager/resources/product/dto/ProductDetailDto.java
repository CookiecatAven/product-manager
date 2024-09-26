package ch.csbe.productmanager.resources.product.dto;

import ch.csbe.productmanager.resources.category.dto.CategoryShowDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * DTO für die detaillierte Ansicht eines Produkts.
 */
@Data
@Schema(description = "DTO zur Anzeige der detaillierten Produktinformationen.")
public class ProductDetailDto {

    @NotNull
    @Schema(description = "Die eindeutige ID des Produkts.", example = "1")
    private Integer id;

    @NotNull
    @Schema(description = "Gibt an, ob das Produkt aktiv ist.", example = "true")
    private Boolean active;

    @NotNull
    @Schema(description = "Die eindeutige Artikelnummer des Produkts (SKU).", example = "ABC12345")
    private String sku;

    @NotNull
    @Schema(description = "Der Name des Produkts.", example = "Laptop")
    private String name;

    @NotNull
    @Schema(description = "Ein Link zu einem Bild des Produkts.", example = "https://example.com/images/laptop.png")
    private String image;

    @NotNull
    @Schema(description = "Eine detaillierte Beschreibung des Produkts.", example = "Ein leistungsstarker Laptop mit 16 GB RAM und 512 GB SSD.")
    private String description;

    @NotNull
    @Schema(description = "Der Preis des Produkts.", example = "999.99")
    private Float price;

    @NotNull
    @Schema(description = "Der Lagerbestand des Produkts.", example = "50")
    private Integer stock;

// todo wie kann der Mapper aus einem Category-Object dieses Dto object erstellen?
    @NotNull
    @Schema(description = "Die Kategorie des Produkts.")
    private CategoryShowDto category;
}
