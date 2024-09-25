package ch.csbe.productmanager.resources.user.dto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * DTO zur Anzeige von Benutzerdaten.
 */
@Data
public class UserShowDto {

    @NotNull
    private Integer id;

    @NotNull
    private String username;
}
