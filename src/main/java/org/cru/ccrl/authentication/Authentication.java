package org.cru.ccrl.authentication;

/**
 * author@lee.braddock
 */
public interface Authentication
{
    public void authenticate(Credential credential) throws AuthenticationException;
}
