package ch.csbe.productmanager.resources.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * Data Transfer Object (DTO) zur Übergabe eines JWT-Tokens.
 * Diese Klasse wird verwendet, um einen Token zwischen dem Server und dem Client auszutauschen.
 */
@Data
public class TokenWrapperDto {

    /**
     * Das JWT (JSON Web Token) zur Authentifizierung.
     * Beispiel: "eyJhbGciOiJIUzI1NiJ9...7UPKTms6DQ6u5w-3wxNDcCkzDH5nSd6FSCURBg0yofg"
     */
    @NotNull
    @Schema(description = "Das JWT.", example = "eyJhbGciOiJIUzI1NiJ9...7UPKTms6DQ6u5w-3wxNDcCkzDH5nSd6FSCURBg0yofg")
    private String token;
}
