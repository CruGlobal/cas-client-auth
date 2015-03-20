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
    public void testLogin() throws IOException
    {
        AuthenticationImpl authentication = new AuthenticationImpl();
        authentication.setHost("https://signintst.cru.org");
        authentication.setPath("cas/login");

        CredentialSet credentialSet = new CredentialSet();

        authentication.authenticate(Iterables.getLast(credentialSet));
    }
}
