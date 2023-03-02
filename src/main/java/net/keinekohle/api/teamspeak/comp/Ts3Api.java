package net.keinekohle.api.teamspeak.comp;

import net.keinekohle.api.teamspeak.events.Ts3Listener;

public class Ts3Api
{
    private final Ts3ApiConfig TS3_API_CONFIG;
    private Telnet telnet;
    private RestApi restApi;
    private Ts3ListenerManager listenerManager;

    public Ts3Api (Ts3ApiConfig ts3ApiConfig)
    {
        this.TS3_API_CONFIG = ts3ApiConfig;
        this.telnet = new Telnet(this);
        this.restApi = new RestApi(this);
        this.listenerManager = new Ts3ListenerManager();
    }

    public RestApi getRestApi ()
    {
        return this.restApi;
    }



    Ts3ApiConfig getApiConfig ()
    {
        return this.TS3_API_CONFIG;
    }

    Ts3ListenerManager getListenerManager ()
    {
        return this.listenerManager;
    }

    public void addListener (Ts3Listener listener)
    {
        this.listenerManager.addListener(listener);
    }
}
