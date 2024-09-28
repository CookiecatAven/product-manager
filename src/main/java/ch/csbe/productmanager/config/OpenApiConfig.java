package ch.csbe.productmanager.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Konfiguriert OpenAPI/Swagger für die Anwendung, um die Dokumentation der API
 * mit JWT-Authentifizierung bereitzustellen.
 */
@Configuration
public class OpenApiConfig {

    /**
     * Erstellt eine benutzerdefinierte OpenAPI-Konfiguration mit einem JWT-Sicherheits-Schema.
     *
     * @return Eine konfigurierte OpenAPI-Instanz mit Sicherheitsanforderungen für JWT (bearerAuth)
     */
    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth"; // Name des Sicherheits-Schemas
        return new OpenAPI()
                // Fügt eine Sicherheitsanforderung für die gesamte API hinzu
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                // Definiert das Sicherheits-Schema, das JWT im Bearer-Format verwendet
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                        )
                );
    }

}
