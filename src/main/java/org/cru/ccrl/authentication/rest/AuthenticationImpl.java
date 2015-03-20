package org.cru.ccrl.authentication.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cru.ccrl.authentication.Credential;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * author@lee.braddock
 */
public class AuthenticationImpl implements Authentication
{
    private String host;

    private String path;

    private final Log log = LogFactory.getLog(getClass());

    @Override
    public void authenticate(Credential credential) throws AuthenticationException
    {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target(host).path(path);

        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_FORM_URLENCODED_TYPE);

        Response response = builder.post(Entity.entity(credential.toForm(), MediaType
                .APPLICATION_FORM_URLENCODED_TYPE));

        if (response.getStatus() != 201)
        {
            String html = response.readEntity(String.class);

            throw new AuthenticationException("Authentication Error : " + response.getStatus() + ", " +
                    response.getStatusInfo() + " message " + html);
        }
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public void setPath(String path)
    {
        this.path = path;
    }
}
