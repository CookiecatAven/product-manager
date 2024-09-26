package ch.csbe.productmanager.resources.user;

import ch.csbe.productmanager.resources.user.dto.UserCreateDto;
import ch.csbe.productmanager.resources.user.dto.UserDetailDto;
import ch.csbe.productmanager.resources.user.dto.UserShowDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller zur Verwaltung der Benutzer.
 * Dokumentiert mit SpringDoc für OpenAPI/Swagger.
 */
@RestController
@RequestMapping("/users")
@Tag(name = "UserController", description = "Verwaltung der Benutzer im System")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Holt alle Benutzer.
     *
     * @return Liste von UserShowDto
     */
    @Operation(summary = "Holt alle Benutzer", description = "Gibt eine Liste von allen im System vorhandenen Benutzern zurück.")
    @ApiResponse(responseCode = "200", description = "Erfolgreich alle Benutzer erhalten.")
    @GetMapping
    public List<UserShowDto> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Holt die Rolle eines Benutzers anhand des Benutzernamens.
     *
     * @param username der Benutzername
     * @return die Rolle des Benutzers oder eine Fehlermeldung, falls der Benutzer nicht gefunden wurde
     */
    @Operation(summary = "Holt die Rolle eines Benutzers", description = "Gibt die Rolle eines Benutzers anhand des Benutzernamens zurück.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Benutzerrolle erfolgreich gefunden."),
            @ApiResponse(responseCode = "404", description = "Benutzer nicht gefunden.")
    })
    @GetMapping("/{username}/role")
    public ResponseEntity<String> getUserRoleByUsername(@PathVariable String username) {
        Optional<User> updatedUser = userService.getUserByUsername(username);
        return updatedUser.map(user -> ResponseEntity.ok(user.getRole()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Setzt die Rolle eines Benutzers.
     *
     * @param username der Benutzername
     * @param role     die neue Rolle
     * @return das aktualisierte UserDetailDto
     */
    @Operation(summary = "Aktualisiert die Rolle eines Benutzers", description = "Setzt die Rolle eines Benutzers basierend auf dem Benutzernamen.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Benutzerrolle erfolgreich aktualisiert."),
            @ApiResponse(responseCode = "404", description = "Benutzer nicht gefunden.")
    })
    @PutMapping("/{username}/role")
    public ResponseEntity<UserDetailDto> setUserRoleByUsername(@PathVariable String username, @RequestBody String role) {
        Optional<UserDetailDto> updatedUser = userService.updateUserRole(username, role);
        return updatedUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Fügt einen neuen Benutzer hinzu.
     *
     * @param user die Daten für den zu erstellenden Benutzer
     * @return der erstellte Benutzer in Form eines UserDetailDto
     */
    @Operation(summary = "Erstellt einen neuen Benutzer", description = "Fügt einen neuen Benutzer in das System ein und gibt die Details des erstellten Benutzers zurück.")
    @ApiResponse(responseCode = "201", description = "Benutzer erfolgreich erstellt.")
    @PostMapping
    public UserDetailDto addUser(@RequestBody UserCreateDto user) {
        return userService.addUser(user);
    }
}
