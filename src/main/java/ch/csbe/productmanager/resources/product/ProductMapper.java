package ch.csbe.productmanager.resources.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (
        componentModel = "Spring"
)
public abstract class ProductMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    public abstract Product toEntity(Product product);
}



