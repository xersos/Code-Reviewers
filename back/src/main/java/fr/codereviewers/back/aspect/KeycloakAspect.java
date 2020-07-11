package fr.codereviewers.back.aspect;

import fr.codereviewers.back.service.KeycloakService;
import org.apache.http.auth.AuthenticationException;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class KeycloakAspect {

    private static final Logger LOGGER = Logger.getLogger(KeycloakAspect.class);

    @Autowired
    private KeycloakService keycloakService;

    @Around(value="execution(* fr.codereviewers.back.controller.rest.*.*(..)) && args(authorization,..))")
    public Object checkAuthentication(ProceedingJoinPoint joinPoint, String authorization) throws AuthenticationException {
        Object object = null;

        if (authorization == null) {
            LOGGER.info("authorization == null");
            throw new AuthenticationException("No token provided");
        }

        if (!this.keycloakService.authentication(authorization)) {
            throw new AuthenticationException("Token seems to be invalid");
        } else {
            try {
                object = joinPoint.proceed();
            } catch (Throwable throwable) {
                LOGGER.warn(throwable.getMessage());
            }
        }

        return object;
    }

    @Before("execution(* fr.codereviewers.back.controller.*Controller.*(..)) && args(..))")
    public void beforeRestFunction() {
        LOGGER.info("Before Function");
    }
}
