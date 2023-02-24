package net.keinekohle.api.teamspeak.comp.interfaces.telnet;

import net.keinekohle.api.teamspeak.comp.Ts3Api;
import net.keinekohle.api.teamspeak.exeptions.TelnetQueryConnectionFailed;

import java.io.IOException;
import java.net.Socket;

/**
 * This class is only used for receiving events from the Teamspeak server
 * because REST-Api can't send events
 */
public class Telnet
{
    private final Ts3Api TS3_API;
    private final TelnetIncoming TELNET_INCOMING;
    private final TelnetOutgoing TELNET_OUTGOING;
    private final TelnetKeepAlive TELNET_KEEP_ALIVE;
    private final Socket socket;
    private long lastMessageSent;

    public Telnet (Ts3Api ts3Api)
    {
        this.TS3_API = ts3Api;
        try
        {
            this.socket = new Socket(this.TS3_API.getTs3ApiConfig().getHostAddress(), this.TS3_API.getTs3ApiConfig().getQueryPort());
        } catch (IOException e)
        {
            throw new TelnetQueryConnectionFailed();
        }
        this.TELNET_INCOMING = new TelnetIncoming(this);
        this.TELNET_OUTGOING = new TelnetOutgoing(this);
        this.TELNET_KEEP_ALIVE = new TelnetKeepAlive(this);
    }

    public void disconnect ()
    {
        this.TELNET_KEEP_ALIVE.interrupt();
        this.TELNET_OUTGOING.interrupt();
        this.TELNET_INCOMING.interrupt();
    }

    public void connect ()
    {
        this.TELNET_KEEP_ALIVE.run();
        this.TELNET_INCOMING.run();
        this.TELNET_OUTGOING.run();
    }

    public Ts3Api getTS3_API ()
    {
        return TS3_API;
    }

    public TelnetIncoming getTELNET_INCOMING ()
    {
        return TELNET_INCOMING;
    }

    public TelnetOutgoing getTELNET_OUTGOING ()
    {
        return TELNET_OUTGOING;
    }

    public TelnetKeepAlive getTELNET_KEEP_ALIVE ()
    {
        return TELNET_KEEP_ALIVE;
    }

    public Socket getSocket ()
    {
        return socket;
    }
}
