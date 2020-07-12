package fr.codereviewers.back.aspect.config;

import fr.codereviewers.back.aspect.KeycloakAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class AspectConfig {

    @Bean
    public KeycloakAspect keycloakAspect() {
        return new KeycloakAspect();
    }
}
