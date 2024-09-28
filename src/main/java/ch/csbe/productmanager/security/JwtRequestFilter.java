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

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final UserService userService;

    private final JwtParser jwtParser;

    public JwtRequestFilter(UserService userService, TokenService tokenService) {
        this.userService = userService;
        jwtParser = Jwts.parserBuilder().setSigningKey(tokenService.getSecretKey()).build();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain chain)
            throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String jwt = authorizationHeader.substring(7);
            username = jwtParser.parseClaimsJws(jwt).getBody().getSubject();
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            Optional<User> foundUser = userService.getUserByUsername(username);
            foundUser.ifPresent(user -> {
                UserPrincipal userPrincipal = new UserPrincipal(user);
                UsernamePasswordAuthenticationToken authenticationToken = new
                        UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            });
        }
        chain.doFilter(request, response);
    }
}

