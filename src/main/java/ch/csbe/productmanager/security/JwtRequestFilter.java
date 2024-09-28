package ch.csbe.productmanager.security;

import ch.csbe.productmanager.resources.user.User;
import ch.csbe.productmanager.resources.user.UserService;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

/**
 * Filter zur Verarbeitung von JWT-Authentifizierungsanfragen.
 * Dieser Filter überprüft das JWT aus dem Authorization-Header und authentifiziert den Benutzer,
 * falls der Token gültig ist.
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final UserService userService;

    private final JwtParser jwtParser;

    /**
     * Konstruktor für JwtRequestFilter, initialisiert den UserService und JwtParser.
     *
     * @param userService Service zur Verwaltung der Benutzerinformationen
     * @param tokenService Service zur Bereitstellung von JWT-bezogenen Informationen
     */
    public JwtRequestFilter(UserService userService, TokenService tokenService) {
        this.userService = userService;
        jwtParser = Jwts.parserBuilder().setSigningKey(tokenService.getSecretKey()).build();
    }

    /**
     * Filtert eingehende Anfragen, überprüft das JWT und authentifiziert den Benutzer.
     *
     * @param request Das HttpServletRequest, das gefiltert wird
     * @param response Das HttpServletResponse für die Antwort
     * @param chain Das FilterChain-Objekt zum Weiterleiten der Anfrage
     * @throws ServletException Wenn eine Servlet-Fehlersituation auftritt
     * @throws IOException Wenn eine E/A-Fehlersituation auftritt
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain chain)
            throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;

        // Überprüft, ob der Authorization-Header vorhanden ist und mit "Bearer " beginnt
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String jwt = authorizationHeader.substring(7);
            // Extrahiert den Benutzernamen (Subject) aus dem JWT
            username = jwtParser.parseClaimsJws(jwt).getBody().getSubject();
        }

        // Wenn ein Benutzername extrahiert wurde und noch keine Authentifizierung im SecurityContext gesetzt ist
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            Optional<User> foundUser = userService.getUserByUsername(username);
            foundUser.ifPresent(user -> {
                UserPrincipal userPrincipal = new UserPrincipal(user);
                UsernamePasswordAuthenticationToken authenticationToken = new
                        UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
                // Setzt die Authentifizierung im SecurityContext
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            });
        }
        // Führt den Filter-Chain fort
        chain.doFilter(request, response);
    }
}
