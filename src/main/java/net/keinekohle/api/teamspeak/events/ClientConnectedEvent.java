package net.keinekohle.api.teamspeak.events;

import net.keinekohle.api.teamspeak.model.Channel;
import net.keinekohle.api.teamspeak.model.Client;

public class ClientConnectedEvent
{
    public Channel channel;
    public Client client;
    public String leaveMessage;

    public ClientConnectedEvent (Channel lastChannel, Client client, String leaveMessage)
    {
        this.channel = lastChannel;
        this.client = client;
        this.leaveMessage = leaveMessage;
    }
}
