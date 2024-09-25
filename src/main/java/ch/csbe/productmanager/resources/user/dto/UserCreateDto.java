package ch.csbe.productmanager.resources.user.dto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * DTO für die Erstellung eines neuen Benutzers.
 */
@Data
public class UserCreateDto {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String role;
}
