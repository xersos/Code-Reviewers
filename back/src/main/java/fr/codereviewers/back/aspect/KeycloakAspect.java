package fr.codereviewers.back.aspect;

import fr.codereviewers.back.service.KeycloakService;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class KeycloakAspect {

    private static final Logger LOGGER = Logger.getLogger(KeycloakAspect.class);

    @Autowired
    private KeycloakService keycloakService;

    @Around(value="execution(* fr.codereviewers.back.controller.*Controller.*()) && args(authorization,..))")
    public Object checkAuthentication(ProceedingJoinPoint joinPoint, String authorization) {
        Object object = null;

        if (authorization == null) {
            LOGGER.info("authorization == null");
            return object;
        }

        if (this.keycloakService.authentication(authorization)) {
            try {
                object = joinPoint.proceed();
            } catch (Throwable throwable) {
                LOGGER.warn(throwable.getMessage());
            }
        }

        return object;
    }
}
