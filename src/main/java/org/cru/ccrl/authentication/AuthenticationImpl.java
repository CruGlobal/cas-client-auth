package org.cru.ccrl.authentication;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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

    private Protocol protocol;

    private final Log log = LogFactory.getLog(getClass());

    @Override
    public void authenticate(Credential credential) throws AuthenticationException
    {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target(host).path(path);

        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_FORM_URLENCODED_TYPE);

        Response response = builder.post(Entity.entity(credential.toForm(), MediaType
                .APPLICATION_FORM_URLENCODED_TYPE));

        if(protocol.equals(Protocol.REST))
        {
            if(response.getStatus() != 201)
            {
                String html = response.readEntity(String.class);

                throw new AuthenticationException("Authentication Error : " + response.getStatus() + ", " +
                        response.getStatusInfo() + " message " + html);
            }
        }
        else if (protocol.equals(Protocol.HTTP))
        {
            if(response.getStatus() != 200)
            {
                String html = response.readEntity(String.class);

                throw new AuthenticationException("Authentication Error : " + response.getStatus() + ", " +
                        response.getStatusInfo() + " message " + html);
            }
        }
        else
        {
            throw new AuthenticationException("Authentication Error : unknown protocol");
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

    public void setProtocol(Protocol protocol)
    {
        this.protocol = protocol;
    }
}
