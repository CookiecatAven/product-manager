package ch.csbe.productmanager.resources.user;

import jakarta.persistence.*;

/**
 * Die User-Klasse repräsentiert einen Benutzer in der Datenbank.
 * Jeder Benutzer hat einen eindeutigen Benutzernamen, ein Passwort und eine Rolle (z.B. Benutzer oder Admin).
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * Die eindeutige ID des Benutzers, die automatisch generiert wird.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Der Benutzername des Benutzers.
     */
    private String username;

    /**
     * Das Passwort des Benutzers (sollte in der Realität verschlüsselt gespeichert werden).
     */
    private String password;

    /**
     * Die Rolle des Benutzers (z.B. "Benutzer" oder "Admin").
     */
    private String role;

    // Getter und Setter für alle Felder

    /**
     * Gibt die ID des Benutzers zurück.
     *
     * @return Benutzer-ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Setzt die ID des Benutzers.
     *
     * @param id Benutzer-ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gibt den Benutzernamen des Benutzers zurück.
     *
     * @return Benutzername
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setzt den Benutzernamen des Benutzers.
     *
     * @param username Benutzername
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gibt das Passwort des Benutzers zurück.
     *
     * @return Passwort
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setzt das Passwort des Benutzers.
     *
     * @param password Passwort
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gibt die Rolle des Benutzers zurück.
     *
     * @return Rolle
     */
    public String getRole() {
        return role;
    }

    /**
     * Setzt die Rolle des Benutzers.
     *
     * @param role Rolle
     */
    public void setRole(String role) {
        this.role = role;
    }
}
