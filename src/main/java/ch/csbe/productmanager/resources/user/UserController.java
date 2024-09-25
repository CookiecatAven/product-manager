package ch.csbe.productmanager.resources.user;

import ch.csbe.productmanager.resources.user.dto.UserCreateDto;
import ch.csbe.productmanager.resources.user.dto.UserDetailDto;
import ch.csbe.productmanager.resources.user.dto.UserShowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller zur Verwaltung der Benutzer.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserShowDto> getAllUsers() {
        return userService.getAllUsers();
    }

    // todo sollte einen wert aus einer enumeration/code-table zurückgeben
    @GetMapping("/{username}/role")
    public String getUserRoleByUsername(@PathVariable String username) {
        Optional<User> user = userService.getUserByUsername(username);
        if (user.isPresent()) {
            return user.get().getRole();
        } else {
            // todo noch den richtigen error code senden -> 404
            return "Benutzer wurde nicht gefunden";
        }
    }

    @PutMapping("/{username}/role")
    public UserDetailDto setUserRoleByUsername(@PathVariable String username, @RequestBody String role) {
        return userService.updateUserRole(username, role);
    }

    @PostMapping
    public UserDetailDto addUser(@RequestBody UserCreateDto user) {
        return userService.addUser(user);
    }
}
