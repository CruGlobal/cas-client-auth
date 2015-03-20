package org.cru.ccrl.authentication;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

/**
 * author@lee.braddock
 */
public class CredentialSet extends HashSet<Credential>
{
    public CredentialSet() throws IOException
    {
        for(String user : Files.readLines(new File("/work/users"), Charsets.UTF_8))
        {
            String[] credential = user.split(":");

            add(new Credential(credential[0], credential[1]));
        }
    }
}
