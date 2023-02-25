package net.keinekohle.api.teamspeak.events;

import net.keinekohle.api.teamspeak.model.Channel;
import net.keinekohle.api.teamspeak.model.Client;

public class ClientDisconnectEvent
{
    public Channel lastChannel;
    public Client client;
    public String leaveMessage;

    public ClientDisconnectEvent (Channel lastChannel, Client client, String leaveMessage)
    {
        this.lastChannel = lastChannel;
        this.client = client;
        this.leaveMessage = leaveMessage;
    }
}
