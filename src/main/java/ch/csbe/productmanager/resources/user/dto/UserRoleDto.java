package ch.csbe.productmanager.resources.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * Data Transfer Object (DTO) für die Benutzerrolle.
 * Dieses DTO enthält Informationen über die Rolle eines Benutzers,
 * wie zum Beispiel "Benutzer" oder "Admin".
 */
@Data
@NoArgsConstructor
@Schema(description = "DTO mit einer Rolle als Inhalt.")
public class UserRoleDto {

    /**
     * Die Rolle des Benutzers.
     * Beispiel: "Admin"
     */
    @NotNull
    @Schema(description = "Die Rolle des Benutzers (z. B. Benutzer oder Admin).", example = "Admin")
    private String role;
}
