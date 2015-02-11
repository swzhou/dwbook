package com.swzhou.dwbook;

import com.google.common.base.Optional;
import com.swzhou.dwbook.dao.UserDAO;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import org.skife.jdbi.v2.DBI;

/**
 * Created by swzhou on 15/2/11.
 */
public class PhoneBookAuthenticator implements Authenticator<BasicCredentials, Boolean> {
    private final UserDAO userDAO;

    public PhoneBookAuthenticator(DBI jdbi) {

        userDAO = jdbi.onDemand(UserDAO.class);
    }

    @Override
    public Optional<Boolean> authenticate(BasicCredentials credentials) throws AuthenticationException {
        boolean validUser = userDAO.getUser(credentials.getUsername(), credentials.getPassword()) == 1;
        return validUser ? Optional.of(true) : Optional.absent();
    }
}
