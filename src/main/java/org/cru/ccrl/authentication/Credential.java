package org.cru.ccrl.authentication;

import javax.ws.rs.core.Form;

/**
 * author@lee.braddock
 */
public class Credential
{
    final private String username;
    final private String password;

    public Credential(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public Form toForm()
    {
        Form form = new Form();

        form.param("username", username);
        form.param("password", password);

        return form;
    }
}
