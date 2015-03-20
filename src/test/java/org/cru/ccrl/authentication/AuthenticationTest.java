package org.cru.ccrl.authentication;

import com.google.common.collect.Iterables;
import org.cru.ccrl.authentication.Authentication;
import org.cru.ccrl.authentication.AuthenticationException;
import org.cru.ccrl.authentication.AuthenticationFactory;
import org.cru.ccrl.authentication.CredentialSet;
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
        Authentication authentication = AuthenticationFactory.getInstance("https://signin.cru.org", "cas/v1/tickets");

        CredentialSet credentialSet = new CredentialSet();

        authentication.authenticate(Iterables.getLast(credentialSet));
    }
}
