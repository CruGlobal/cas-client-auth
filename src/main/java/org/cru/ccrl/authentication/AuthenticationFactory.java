package org.cru.ccrl.authentication;

/**
 * author@lee.braddock
 */
public class AuthenticationFactory
{
    public static Authentication getInstance(String host, String path, Protocol protocol)
    {
        AuthenticationImpl authentication = new AuthenticationImpl();

        authentication.setHost(host);
        authentication.setPath(path);
        authentication.setProtocol(protocol);

        return authentication;
    }
}
