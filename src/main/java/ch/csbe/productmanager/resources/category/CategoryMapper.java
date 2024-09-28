package ch.csbe.productmanager.resources.category;

import ch.csbe.productmanager.resources.category.dto.CategoryCreateDto;
import ch.csbe.productmanager.resources.category.dto.CategoryDetailDto;
import ch.csbe.productmanager.resources.category.dto.CategoryShowDto;
import ch.csbe.productmanager.resources.category.dto.CategoryUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * Mapper zur Umwandlung von Category-Entitäten zu DTOs und umgekehrt.
 */
@Mapper(componentModel = "spring")
public abstract class CategoryMapper {

    /**
     * Umwandlung von Category zu CategoryShowDto.
     *
     * @param category die Category-Entität
     * @return das CategoryShowDto
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "active", target = "active")
    @Mapping(source = "name", target = "name")
    public abstract CategoryShowDto toShowDto(Category category);

    /**
     * Umwandlung von Category zu CategoryDetailDto.
     *
     * @param category die Category-Entität
     * @return das CategoryDetailDto
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "active", target = "active")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "products", target = "products")
    public abstract CategoryDetailDto toDetailDto(Category category);

    /**
     * Umwandlung von CategoryCreateDto zu Category.
     *
     * @param createDto die CategoryCreateDto-Entität
     * @return die Category-Entität
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "active", target = "active")
    @Mapping(source = "name", target = "name")
    @Mapping(target = "products", ignore = true)
    public abstract Category toEntity(CategoryCreateDto createDto);

    /**
     * Update von Category durch CategoryShowDto.
     *
     * @param categoryUpdateDto      das CategoryUpdateDto mit den neuen Daten
     * @param categoryEntityToUpdate die Category-Entität, welche aktualisiert werden soll
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "active", target = "active")
    @Mapping(source = "name", target = "name")
    @Mapping(target = "products", ignore = true)
    public abstract void update(CategoryUpdateDto categoryUpdateDto, @MappingTarget Category categoryEntityToUpdate);
}
