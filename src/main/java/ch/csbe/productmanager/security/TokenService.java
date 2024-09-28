package ch.csbe.productmanager.security;

import ch.csbe.productmanager.resources.user.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.sql.Date;

/**
 * Service zur Erstellung und Verwaltung von JWT-Tokens.
 * Dieser Service erzeugt JWT-Tokens für authentifizierte Benutzer und stellt den geheimen Schlüssel bereit,
 * der für die Token-Validierung verwendet wird.
 */
@Service
public class TokenService {

    // Der geheime Schlüssel zur Signierung der JWT-Tokens
    private final Key SECRET_KEY = Keys.hmacShaKeyFor("H36WGA5MSS1CSB0MJ03FWL3RA37B18N6".getBytes());

    /**
     * Erzeugt ein JWT-Token für einen bestimmten Benutzer.
     * Das Token enthält den Benutzernamen und die Rolle des Benutzers sowie die Gültigkeitsdauer.
     *
     * @param user Der Benutzer, für den das Token erstellt werden soll
     * @return Das generierte JWT-Token als String
     */
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("roles", user.getRole())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 Stunden Gültigkeit
                .signWith(SECRET_KEY)
                .compact();
    }

    /**
     * Gibt den geheimen Schlüssel zurück, der zur Signierung und Überprüfung von JWT-Tokens verwendet wird.
     *
     * @return Der geheime Schlüssel als Key-Objekt
     */
    public Key getSecretKey() {
        return SECRET_KEY;
    }
}
