package ch.csbe.productmanager.db;

import org.flywaydb.core.Flyway;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * Hat die Funktion vom drop in jpa.hibernate.ddl-auto: create-drop
 */
@Component
public class FlywayCleanShutdownListener implements ApplicationListener<ContextClosedEvent> {

    private final Flyway flyway;

    public FlywayCleanShutdownListener(Flyway flyway) {
        this.flyway = flyway;
    }

    @Override
    public void onApplicationEvent(@NotNull ContextClosedEvent event) {
        flyway.clean();
    }
}