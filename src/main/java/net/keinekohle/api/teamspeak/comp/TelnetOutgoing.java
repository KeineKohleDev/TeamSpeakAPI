package net.keinekohle.api.teamspeak.comp;

import net.keinekohle.api.teamspeak.model.Command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

class TelnetOutgoing extends Thread
{
    private final Telnet TELNET;
    private PrintWriter writer;
    private final Queue<Command> COMMAND_QUEUE = new LinkedList<>();

    public TelnetOutgoing (Telnet telnet)
    {
        this.TELNET = telnet;
        try
        {
            this.writer = new PrintWriter(this.TELNET.getSocket().getOutputStream(), true);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run ()
    {
        loginProperly();

        while (!interrupted())
        {
            if (!this.COMMAND_QUEUE.isEmpty())
            {
                this.writer.println(this.COMMAND_QUEUE.peek().toString());
                this.COMMAND_QUEUE.peek().setSentTime();
                if (this.TELNET.getAPI().getApiConfig().isEnableLogging()) System.out.println("Sent: " + this.COMMAND_QUEUE.peek().toString());
                this.TELNET.getTELNET_INCOMING().getRECEIVE_QUEUE().add(this.getCOMMAND_QUEUE().poll());
                this.TELNET.updateLastMessageSent();
            }
            // Add sleep to save resources
            try
            {
                Thread.sleep(1);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Login, select virtual server and register events
     */
    private void loginProperly ()
    {
        // Login and select server
        this.COMMAND_QUEUE.add(new Command("login", new String[]{this.TELNET.getAPI().getApiConfig().getQueryLoginName(), this.TELNET.getAPI().getApiConfig().getQueryPassword()}));
        this.COMMAND_QUEUE.add(new Command("use", new String[]{"port=" + this.TELNET.getAPI().getApiConfig().getServerPort()}));
        // Register all events
        this.COMMAND_QUEUE.add(new Command("servernotifyregister", new String[]{"event=channel id=0"}));
        this.COMMAND_QUEUE.add(new Command("servernotifyregister", new String[]{"event=textchannel id=0"}));
        this.COMMAND_QUEUE.add(new Command("servernotifyregister", new String[]{"event=textprivate"}));
        this.COMMAND_QUEUE.add(new Command("servernotifyregister", new String[]{"event=textserver"}));
        this.COMMAND_QUEUE.add(new Command("servernotifyregister", new String[]{"event=server"}));
    }

    Queue<Command> getCOMMAND_QUEUE ()
    {
        return this.COMMAND_QUEUE;
    }
}
