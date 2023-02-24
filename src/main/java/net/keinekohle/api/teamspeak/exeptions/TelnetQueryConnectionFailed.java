package net.keinekohle.api.teamspeak.exeptions;

import net.keinekohle.api.teamspeak.util.Errors;

public class TelnetQueryConnectionFailed extends RuntimeException
{
    public TelnetQueryConnectionFailed ()
    {
        super(Errors.TELNET_QUERY_CONNECTION_FAILED);
    }
}
