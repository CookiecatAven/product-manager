package ch.csbe.productmanager.resources.product;

import ch.csbe.productmanager.resources.product.dto.ProductCreateDto;
import ch.csbe.productmanager.resources.product.dto.ProductDetailDto;
import ch.csbe.productmanager.resources.product.dto.ProductShowDto;
import ch.csbe.productmanager.resources.product.dto.ProductUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * Mapper für die Umwandlung zwischen Product-Entitäten und deren entsprechenden DTOs.
 * Dieser Mapper wird von MapStruct generiert und konvertiert Product-Entitäten zu DTOs und umgekehrt.
 */
@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    /**
     * Konvertiert ein Product-Objekt in ein ProductShowDto.
     *
     * @param product Das Produkt, das konvertiert werden soll
     * @return Ein DTO zur Anzeige eines Produkts
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "active", target = "active")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "stock", target = "stock")
    public abstract ProductShowDto toShowDto(Product product);

    /**
     * Konvertiert ein Product-Objekt in ein ProductDetailDto.
     *
     * @param product Das Produkt, das konvertiert werden soll
     * @return Ein DTO mit den detaillierten Informationen eines Produkts
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "active", target = "active")
    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "category", target = "category")
    public abstract ProductDetailDto toDetailDto(Product product);

    /**
     * Konvertiert ein ProductCreateDto in eine Product-Entität.
     *
     * @param product DTO mit den Informationen für die Erstellung eines Produkts
     * @return Eine neue Produkt-Entität
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "active", target = "active")
    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "stock", target = "stock")
    @Mapping(target = "category", ignore = true)
    public abstract Product toEntity(ProductCreateDto product);

    /**
     * Aktualisiert ein bestehendes Produkt mit den Daten aus einem ProductUpdateDto.
     *
     * @param productUpdateDto Die neuen Informationen für das zu aktualisierende Produkt
     * @param productEntityToUpdate Die vorhandene Produkt-Entität, die aktualisiert werden soll
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "active", target = "active")
    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "stock", target = "stock")
    @Mapping(target = "category", ignore = true)
    public abstract void update(ProductUpdateDto productUpdateDto, @MappingTarget Product productEntityToUpdate);
}
