package net.keinekohle.api.teamspeak.comp;

import net.keinekohle.api.teamspeak.comp.Ts3Api;

/**
 * Interface to the REST-Api of teamspeak
 */
public class RestApi
{
    private final Ts3Api TS3_API;

    public RestApi (Ts3Api ts3Api)
    {
        this.TS3_API = ts3Api;
    }
}
