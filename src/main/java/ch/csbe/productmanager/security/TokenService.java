package ch.csbe.productmanager.security;

import ch.csbe.productmanager.resources.user.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.sql.Date;

@Service
public class TokenService {

    private final Key SECRET_KEY = Keys.hmacShaKeyFor("H36WGA5MSS1CSB0MJ03FWL3RA37B18N6".getBytes());

    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("roles", user.getRole())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SECRET_KEY)
                .compact();
    }

    public Key getSecretKey() {
        return SECRET_KEY;
    }
}
