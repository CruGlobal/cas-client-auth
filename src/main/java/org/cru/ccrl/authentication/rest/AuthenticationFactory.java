package org.cru.ccrl.authentication.rest;

/**
 * author@lee.braddock
 */
public class AuthenticationFactory
{
    public static Authentication getInstance(String host, String path)
    {
        AuthenticationImpl authentication = new AuthenticationImpl();

        authentication.setHost(host);
        authentication.setPath(path);

        return authentication;
    }
}
