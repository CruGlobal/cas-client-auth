package org.cru.ccrl.authentication;

import com.google.common.collect.Iterables;
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
