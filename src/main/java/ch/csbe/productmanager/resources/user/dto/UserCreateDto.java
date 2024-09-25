package ch.csbe.productmanager.resources.user.dto;

import org.jetbrains.annotations.NotNull;

/**
 * DTO für die Erstellung eines neuen Benutzers.
 */
public class UserCreateDto {

    @org.jetbrains.annotations.NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String role;

    // Getter und Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
