package net.keinekohle.api.teamspeak.comp.interfaces.telnet;

import net.keinekohle.api.teamspeak.model.Command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class TelnetOutgoing extends Thread
{
    private final Telnet TELNET;
    private PrintWriter writer;
    private final Queue<Command> COMMAND_QUEUE = new LinkedList<>();

    public TelnetOutgoing (Telnet telnet)
    {
        this.TELNET = telnet;
        try
        {
            this.writer = new PrintWriter(this.TELNET.getSocket().getOutputStream());
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run ()
    {
        loginProperly();
    }

    /**
     * Login and select virtual server
     */
    private void loginProperly ()
    {
        this.writer.println("login " + this.TELNET.getTS3_API().getTs3ApiConfig().getQueryLoginName() + " " + this.TELNET.getTS3_API().getTs3ApiConfig().getQueryPassword());
    }

    public Queue<Command> getCOMMAND_QUEUE ()
    {
        return this.COMMAND_QUEUE;
    }
}
