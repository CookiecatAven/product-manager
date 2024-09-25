package ch.csbe.productmanager.resources.user.dto;


import org.antlr.v4.runtime.misc.NotNull;

/**
 * DTO zur Anzeige von Benutzerdaten.
 */
public class UserShowDto {

    @NotNull
    private Integer id;

    @NotNull
    private String username;

    private String role;

    // Getter und Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

