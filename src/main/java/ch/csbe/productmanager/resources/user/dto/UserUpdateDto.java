package ch.csbe.productmanager.resources.user.dto;


/**
 * DTO zur Aktualisierung von Benutzerdaten.
 */
public class UserUpdateDto {

    private String username;
    private String password;
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
