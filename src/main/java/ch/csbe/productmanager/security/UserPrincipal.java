package ch.csbe.productmanager.security;

import ch.csbe.productmanager.resources.user.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * Repräsentiert die Benutzer-Details (UserPrincipal) für die Authentifizierung.
 * Diese Klasse implementiert das {@link UserDetails}-Interface und stellt die
 * benutzerrelevanten Informationen für Spring Security bereit.
 */
@Data
public class UserPrincipal implements UserDetails {

    private User user;

    /**
     * Konstruktor für den UserPrincipal.
     *
     * @param user Das User-Objekt, das die Benutzerdaten enthält
     */
    public UserPrincipal(User user) {
        this.user = user;
    }

    /**
     * Gibt die Rollen bzw. Berechtigungen des Benutzers zurück.
     *
     * @return Eine Collection mit den Berechtigungen des Benutzers
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }

    /**
     * Gibt das verschlüsselte Passwort des Benutzers zurück.
     *
     * @return Das Passwort des Benutzers
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Gibt den Benutzernamen zurück.
     *
     * @return Der Benutzername des Benutzers
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

}
