package ch.csbe.productmanager.resources.user;

import ch.csbe.productmanager.resources.user.dto.UserCreateDto;
import ch.csbe.productmanager.resources.user.dto.UserDetailDto;
import ch.csbe.productmanager.resources.user.dto.UserShowDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper zur Umwandlung von User-Entitäten zu DTOs und umgekehrt.
 */
@Mapper(componentModel = "spring")
public abstract class UserMapper {

    /**
     * Umwandlung von User zu UserShowDto.
     *
     * @param user die Benutzer-Entität
     * @return das UserShowDto
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    public abstract UserShowDto toShowDto(User user);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "role", target = "role")
    public abstract UserDetailDto toDetailDto(User user);

    /**
     * Umwandlung von UserCreateDto zu User.
     *
     * @param createDto das DTO zur Benutzererstellung
     * @return die Benutzer-Entität
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(target = "role", ignore = true)
    public abstract User toEntity(UserCreateDto createDto);
}
