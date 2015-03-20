package org.cru.ccrl.authentication.rest;

import com.google.common.collect.Iterables;
import org.cru.ccrl.authentication.CredentialSet;
import org.cru.ccrl.authentication.rest.AuthenticationException;
import org.cru.ccrl.authentication.rest.AuthenticationImpl;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * author@lee.braddock
 */
public class AuthenticationTest
{
    @Test
    public void testLogin() throws IOException, AuthenticationException
    {
        AuthenticationImpl authentication = new AuthenticationImpl();
        authentication.setHost("https://signin.cru.org");
        authentication.setPath("cas/v1/tickets");

        CredentialSet credentialSet = new CredentialSet();

        authentication.authenticate(Iterables.getLast(credentialSet));
    }
}
