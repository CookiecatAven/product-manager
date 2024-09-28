package ch.csbe.productmanager.resources.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class LoginRequestDto {

    @NotNull
    @Schema(description = "Der Benutzername des einzuloggenden Benutzers.", example = "julie_sun")
    private String username;

    @NotNull
    @Schema(description = "Das Passwort des Benutzers.", example = "1538")
    private String password;
}
