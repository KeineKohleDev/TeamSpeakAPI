package net.keinekohle.api.teamspeak.comp;

/**
 * Thread to keep the connection to the teamspeak query alive
 */
public class TelnetKeepAlive extends Thread
{
    private final Telnet TELNET;

    public TelnetKeepAlive (Telnet telnet)
    {
        this.TELNET = telnet;
    }
}
