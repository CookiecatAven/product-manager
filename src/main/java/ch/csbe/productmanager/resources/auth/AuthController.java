package ch.csbe.productmanager.resources.auth;

import ch.csbe.productmanager.resources.auth.dto.LoginRequestDto;
import ch.csbe.productmanager.resources.auth.dto.TokenWrapperDto;
import ch.csbe.productmanager.resources.user.User;
import ch.csbe.productmanager.resources.user.UserService;
import ch.csbe.productmanager.security.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final UserService userService;

    private final TokenService tokenService;

    public AuthController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    /**
     * Logt einen User ein und sendet ein generiertes JWT zurück.
     *
     * @param loginRequestDto die Logindaten
     * @return das erzeugt JWT
     */
    @Operation(summary = "User Login", description = "Ermöglicht das einloggen und gibt ein JWT zurück.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login erfolgreich."),
            @ApiResponse(responseCode = "401", description = "Login fehlgeschlagen.")
    })
    @PostMapping("login")
    public ResponseEntity<TokenWrapperDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        Optional<User> foundUser = userService.getUserWithCredentials(loginRequestDto.getUsername(), loginRequestDto.getPassword());
        return foundUser.map(user -> {
            String token = tokenService.generateToken(user);
            TokenWrapperDto tokenWrapper = new TokenWrapperDto(token);
            return ResponseEntity.ok(tokenWrapper);
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
