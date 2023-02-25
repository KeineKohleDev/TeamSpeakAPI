package net.keinekohle.api.teamspeak.comp;

import net.keinekohle.api.teamspeak.model.Command;
import net.keinekohle.api.teamspeak.util.ResponseParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class TelnetIncoming extends Thread
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
            this.skipWelcomeText();
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
            String line;
            try {
                line = this.reader.readLine();
                if (line.length() == 0) continue;
                if (line.startsWith("notify"))
                {
                    System.out.println(line);
                    continue;
                }
                if (!this.RECEIVE_QUEUE.isEmpty())
                {
                    if (this.TELNET.getAPI().getApiConfig().isEnableLogging()) System.out.println("\nReceiving: '" + line + "' for command: '" + this.RECEIVE_QUEUE.peek().toString() + "'");
                    ResponseParser.pars(this.RECEIVE_QUEUE.peek().getResponse(), line);
                    if (this.RECEIVE_QUEUE.peek().getResponse().get("status").getAsJsonObject().get("code") != null)
                    {
                        this.RECEIVE_QUEUE.peek().timing();
                        System.out.println("Removed command from queue: "+this.getRECEIVE_QUEUE().poll().toString());
                    }
                }
            } catch (IOException e)
            {
                throw  new RuntimeException(e);
            }
        }
    }

    private void skipWelcomeText() throws IOException {
        for (int i = 0; i < 4 || this.reader.ready(); ++i) {
            this.reader.readLine();
        }
    }

    Queue<Command> getRECEIVE_QUEUE ()
    {
        return RECEIVE_QUEUE;
    }
}
