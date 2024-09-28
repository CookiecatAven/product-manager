package ch.csbe.productmanager.resources.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class TokenWrapperDto {

    @NotNull
    @Schema(description = "Das JWT.", example = "eyJhbGciOiJIUzI1NiJ9...7UPKTms6DQ6u5w-3wxNDcCkzDH5nSd6FSCURBg0yofg")
    private String token;
}
