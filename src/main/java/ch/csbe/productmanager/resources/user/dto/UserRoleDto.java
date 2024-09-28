package ch.csbe.productmanager.resources.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@Schema(description = "DTO mit einer Rolle als Inhalt.")
public class UserRoleDto {

    @NotNull
    @Schema(description = "Die Rolle des Benutzers (z. B. Benutzer oder Admin).", example = "Admin")
    private String role;
}
