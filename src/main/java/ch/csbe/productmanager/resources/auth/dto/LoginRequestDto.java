package ch.csbe.productmanager.resources.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * Data Transfer Object (DTO) für Login-Anfragen.
 * Diese Klasse enthält die notwendigen Daten, die für eine Login-Anfrage
 * erforderlich sind, nämlich den Benutzernamen und das Passwort.
 */
@Data
public class LoginRequestDto {

    /**
     * Der Benutzername des einzuloggenden Benutzers.
     * Beispiel: "julie_sun"
     */
    @NotNull
    @Schema(description = "Der Benutzername des einzuloggenden Benutzers.", example = "julie_sun")
    private String username;

    /**
     * Das Passwort des Benutzers.
     * Beispiel: "1538"
     */
    @NotNull
    @Schema(description = "Das Passwort des Benutzers.", example = "1538")
    private String password;
}
