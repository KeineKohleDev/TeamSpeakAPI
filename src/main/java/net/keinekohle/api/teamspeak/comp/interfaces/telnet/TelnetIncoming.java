package net.keinekohle.api.teamspeak.comp.interfaces.telnet;

import net.keinekohle.api.teamspeak.model.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class TelnetIncoming extends Thread
{
    private final Telnet TELNET;
    private final BufferedReader reader;
    private final Queue<Command> RECEIVE_QUEUE = new LinkedList<>();

    public TelnetIncoming (Telnet telnet)
    {
        this.TELNET = telnet;
        try
        {
            this.reader = new BufferedReader(new InputStreamReader(this.TELNET.getSocket().getInputStream()));
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run ()
    {
        while (!isInterrupted())
        {

        }
    }

    public Queue<Command> getRECEIVE_QUEUE ()
    {
        return RECEIVE_QUEUE;
    }
}
