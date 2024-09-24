package ch.csbe.productmanager.resources.user;

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
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{username}/role")
    public String getUserRoleByUsername(@PathVariable String username) {
        Optional<User> user = userService.getUserByUsername(username);
        if (user.isPresent()) {
            return user.get().getRole();
        } else {
            return "Benutzer wurde nicht gefunden";
        }
    }

    @PutMapping("/{username}/role")
    public boolean setUserRoleByUsername(@PathVariable String username, @RequestBody String role) {
        Optional<User> user = userService.getUserByUsername(username);
        if (user.isPresent()) {
            user.get().setRole(role);
            userService.updateUser(user.get().getId(), user.get());
            return true;
        } else {
            return false;
        }
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
