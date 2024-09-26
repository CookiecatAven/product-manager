package ch.csbe.productmanager.resources.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * DTO zur Anzeige grundlegender Benutzerdaten.
 */
@Data
@Schema(description = "DTO zur Anzeige grundlegender Benutzerdaten.")
public class UserShowDto {

    @NotNull
    @Schema(description = "Die eindeutige ID des Benutzers.", example = "5")
    private Integer id;

    @NotNull
    @Schema(description = "Der Benutzername des Benutzers.", example = "julie_sun")
    private String username;
}
