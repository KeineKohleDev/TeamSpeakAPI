package net.keinekohle.api.teamspeak.comp;

import net.keinekohle.api.teamspeak.comp.Ts3Api;
import net.keinekohle.api.teamspeak.model.Client;

/**
 * Interface to the REST-Api of teamspeak
 */
class RestApi
{
    private final Ts3Api TS3_API;

    public RestApi (Ts3Api ts3Api)
    {
        this.TS3_API = ts3Api;
    }

    public Client getClientById (int id)
    {
        return new Client();
    }

    public Client getClientByUUID (int uuid)
    {
        return new Client();
    }

    public Client getClientByName (String name)
    {
        return new Client();
    }
}
