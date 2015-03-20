package org.cru.ccrl.authentication.rest;

import org.cru.ccrl.authentication.Credential;

/**
 * author@lee.braddock
 */
public interface Authentication
{
    public void authenticate(Credential credential) throws AuthenticationException;
}
