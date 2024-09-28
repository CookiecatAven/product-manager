package ch.csbe.productmanager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Sicherheitskonfiguration für die Anwendung.
 * Diese Klasse definiert die Filter und Sicherheitsregeln für HTTP-Anfragen.
 */
@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

    private final JwtRequestFilter jwtRequestFilter;

    /**
     * Konstruktor für die Sicherheitskonfiguration.
     *
     * @param jwtRequestFilter Filter zur Überprüfung von JWTs bei eingehenden Anfragen
     */
    public SecurityConfiguration(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    /**
     * Konfiguriert die Sicherheitsfilterkette und legt fest, welche Anfragen authentifiziert werden müssen.
     *
     * @param http Die HttpSecurity-Instanz zur Konfiguration von Sicherheitsregeln
     * @return Die konfigurierte Sicherheitsfilterkette
     * @throws Exception Falls bei der Konfiguration ein Fehler auftritt
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Füge den JWT-Filter vor dem Standard-Authentifizierungsfilter hinzu
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        // Konfiguriert die Sicherheitsregeln
        http
                .httpBasic(AbstractHttpConfigurer::disable) // Deaktiviert Basic Auth
                .csrf(AbstractHttpConfigurer::disable) // Deaktiviert CSRF-Schutz
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll() // Login-Endpunkt
                        .requestMatchers(HttpMethod.POST, "/users").permitAll() // Registrierung
                        .requestMatchers(HttpMethod.GET, "/products").permitAll() // Alle Produkte einsehen
                        .requestMatchers(HttpMethod.GET, "/products/*").permitAll() // Einzelne Produkte einsehen
                        .requestMatchers(HttpMethod.GET, "/categories").permitAll() // Alle Kategorien einsehen
                        .requestMatchers(HttpMethod.GET, "/categories/*").permitAll() // Einzelne Kategorien einsehen
                        .requestMatchers("/swagger-ui.html").permitAll() // Swagger UI
                        .requestMatchers("/swagger-ui/*").permitAll() // Swagger Ressourcen
                        .requestMatchers("/v3/api-docs").permitAll() // API-Dokumentation
                        .requestMatchers("/v3/api-docs/swagger-config").permitAll() // Swagger-Konfiguration
                        .anyRequest().authenticated()); // Alle anderen Anfragen müssen authentifiziert sein

        return http.build(); // Baut und gibt die Sicherheitsfilterkette zurück
    }
}
