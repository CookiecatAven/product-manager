package ch.csbe.productmanager.security;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.stereotype.Component;

/**
 * BeanPostProcessor zur Anpassung von Beans nach ihrer Initialisierung.
 * In diesem Fall wird der AuthorizationFilter angepasst.
 */
@Component
public class PostProcessorBean implements BeanPostProcessor {

    /**
     * Passt den AuthorizationFilter an, indem das `setFilterErrorDispatch`-Flag auf `false` gesetzt wird.
     *
     * @param bean Das zu verarbeitende Bean
     * @param beanName Der Name des Beans
     * @return Das verarbeitete Bean (kann angepasst oder unverändert sein)
     * @throws BeansException Wenn es Probleme bei der Verarbeitung des Beans gibt
     */
    @Override
    public Object postProcessAfterInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
        if (bean instanceof AuthorizationFilter authorizationFilter) {
            // Deaktiviert die Fehlerweiterleitung im AuthorizationFilter
            authorizationFilter.setFilterErrorDispatch(false);
        }
        return bean;
    }
}
