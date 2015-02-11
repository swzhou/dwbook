package com.swzhou.dwbook;

import com.google.common.base.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

/**
 * Created by swzhou on 15/2/11.
 */
public class PhoneBookAuthenticator implements Authenticator<BasicCredentials, Boolean> {
    private final String authUser;
    private final String authPassword;

    public PhoneBookAuthenticator(String authUser, String authPassword) {

        this.authUser = authUser;
        this.authPassword = authPassword;
    }

    @Override
    public Optional<Boolean> authenticate(BasicCredentials credentials) throws AuthenticationException {
        if(credentials.getUsername().equals(authUser) && credentials.getPassword().equals(authPassword)) {
            return Optional.of(true);
        }
        return Optional.absent();
    }
}
