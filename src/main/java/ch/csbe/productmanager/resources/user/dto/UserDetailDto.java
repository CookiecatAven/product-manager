package ch.csbe.productmanager.resources.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * DTO zur Anzeige detaillierter Benutzerdaten.
 */
@Data
@Schema(description = "DTO zur Anzeige detaillierter Informationen eines Benutzers.")
public class UserDetailDto {

    @NotNull
    @Schema(description = "Die eindeutige ID des Benutzers.", example = "1")
    private Integer id;

    @NotNull
    @Schema(description = "Der Benutzername des Benutzers.", example = "julie_sun")
    private String username;

    @NotNull
    @Schema(description = "Die Rolle des Benutzers (z. B. Benutzer oder Admin).", example = "Admin")
    private String role;
}
