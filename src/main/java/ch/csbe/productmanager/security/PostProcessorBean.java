package ch.csbe.productmanager.security;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.stereotype.Component;

@Component
public class PostProcessorBean implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
        if (bean instanceof AuthorizationFilter authorizationFilter) {
            authorizationFilter.setFilterErrorDispatch(false);
        }
        return bean;
    }
}
