package net.keinekohle.api.teamspeak.comp;

import net.keinekohle.api.teamspeak.comp.interfaces.restapi.RestApi;
import net.keinekohle.api.teamspeak.comp.interfaces.telnet.Telnet;

import java.io.IOException;

public class Ts3Api
{
    private final Ts3ApiConfig TS3_API_CONFIG;
    private Telnet telnet;
    private RestApi restApi;

    public Ts3Api (Ts3ApiConfig ts3ApiConfig)
    {
        this.TS3_API_CONFIG = ts3ApiConfig;
        if (ts3ApiConfig.isEnableTelnet()) this.telnet = new Telnet(this);
        if (ts3ApiConfig.isEnableRestApi()) this.restApi = new RestApi(this);
    }

    public Ts3ApiConfig getTs3ApiConfig ()
    {
        return TS3_API_CONFIG;
    }

    public Telnet getTelnet ()
    {
        return telnet;
    }

    public RestApi getRestApi ()
    {
        return restApi;
    }
}
