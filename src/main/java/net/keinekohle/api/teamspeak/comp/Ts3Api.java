package net.keinekohle.api.teamspeak.comp;

public class Ts3Api
{
    private final Ts3ApiConfig TS3_API_CONFIG;
    private Telnet telnet;
    private RestApi restApi;

    public Ts3Api (Ts3ApiConfig ts3ApiConfig)
    {
        this.TS3_API_CONFIG = ts3ApiConfig;
        this.telnet = new Telnet(this);
        this.restApi = new RestApi(this);
    }

    public RestApi getRestApi ()
    {
        return this.restApi;
    }



    Ts3ApiConfig getApiConfig ()
    {
        return TS3_API_CONFIG;
    }
}
