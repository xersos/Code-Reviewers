package fr.codereviewers.back.shared.service;


import org.apache.log4j.Logger;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.representations.idm.authorization.AuthorizationRequest;
import org.keycloak.representations.idm.authorization.AuthorizationResponse;
import org.springframework.stereotype.Service;

@Service
public class KeycloakService {

    private static final Logger LOGGER = Logger.getLogger(KeycloakService.class);
    private AuthzClient authzClient = AuthzClient.create();

    public boolean authentication(String token) {
        AuthorizationRequest request = new AuthorizationRequest();
        AuthorizationResponse response = this.authzClient.authorization(token).authorize(request);

        String tkn = response.getToken();
        LOGGER.info("authentication token: " + tkn);
        return tkn != null;
    }
}
