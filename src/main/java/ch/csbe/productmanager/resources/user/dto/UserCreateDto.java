package ch.csbe.productmanager.resources.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * DTO für die Erstellung eines neuen Benutzers.
 */
@Data
@Schema(description = "DTO zur Erstellung eines neuen Benutzers.")
public class UserCreateDto {

    @NotNull
    @Schema(description = "Der Benutzername des neuen Benutzers.", example = "julie_sun")
    private String username;

    @NotNull
    @Schema(description = "Das Passwort des neuen Benutzers.", example = "1538")
    private String password;
}
