package net.keinekohle.api.teamspeak.comp;

import net.keinekohle.api.teamspeak.events.ClientConnectedEvent;
import net.keinekohle.api.teamspeak.events.Ts3Listener;

import java.util.ArrayList;
import java.util.List;

public class Ts3ListenerManager
{
    private List<Ts3Listener> listeners = new ArrayList<>();

    public void addListener (Ts3Listener listener)
    {
        this.listeners.add(listener);
    }

    public void notifyClientConnected (ClientConnectedEvent event)
    {
        for (Ts3Listener ts3Listener : listeners)
        {
            ts3Listener.clientConnect(event);
        }
    }
}
