package net.keinekohle.api.teamspeak.comp;

import net.keinekohle.api.teamspeak.util.Defaults;

public class Ts3ApiConfig
{
    private String hostAddress;
    private String queryLoginName;
    private String queryPassword;
    private String apiToken;
    private int queryPort;
    private int httpPort;
    private int serverPort;
    private boolean enableTelnet;
    private boolean enableRestApi;
    private boolean enableLogging;

    private Ts3ApiConfig ()
    {
        this.queryPort = Defaults.DEFAULT_QUERY_PORT;
        this.httpPort = Defaults.DEFAULT_HTTP_PORT;
        this.serverPort = Defaults.DEFAULT_SERVER_PORT;
        this.enableTelnet = Defaults.DEFAULT_ENABLE_TELNET;
        this.enableRestApi = Defaults.DEFAULT_ENABLE_REST_API;
        this.enableLogging = Defaults.DEFAULT_ENABLE_LOGGING;
    }


    public void setHostAddress (String hostAddress)
    {
        this.hostAddress = hostAddress;
    }

    /**
     * Login name of the telnet query
     *
     * @param queryLoginName
     */
    public void setQueryLoginName (String queryLoginName)
    {
        this.queryLoginName = queryLoginName;
    }

    /**
     * Password of the telnet query
     *
     * @param queryPassword
     */
    public void setQueryPassword (String queryPassword)
    {
        this.queryPassword = queryPassword;
    }

    /**
     * @param apiToken Api token for the REST-Api
     */
    public void setApiToken (String apiToken)
    {
        this.apiToken = apiToken;
    }

    /**
     * Set to the default port at default
     *
     * @param queryPort Port of the telnet backend
     */
    public void setQueryPort (int queryPort)
    {
        this.queryPort = queryPort;
    }

    /**
     * Set to the default port at default
     *
     * @param httpPort Port of the REST-Api backend
     */
    public void setHttpPort (int httpPort)
    {
        this.httpPort = httpPort;
    }

    /**
     * @param enableTelnet Enables or disables the telnet query
     */
    public void setEnableTelnet (boolean enableTelnet)
    {
        this.enableTelnet = enableTelnet;
    }

    /**
     * @param enableRestApi Enables or disables the REST-Api
     */
    public void setEnableRestApi (boolean enableRestApi)
    {
        this.enableRestApi = enableRestApi;
    }

    /**
     * @param enableLogging Enables or disables logging
     */
    public void setEnableLogging (boolean enableLogging)
    {
        this.enableLogging = enableLogging;
    }

    /**
     * Set to the default port at default
     *
     * @param serverPort Port of the Teamspeak-Server
     */
    public void setServerPort (int serverPort)
    {
        this.serverPort = serverPort;
    }

    public String getHostAddress ()
    {
        return hostAddress;
    }

    public String getQueryLoginName ()
    {
        return queryLoginName;
    }

    public String getQueryPassword ()
    {
        return queryPassword;
    }

    public String getApiToken ()
    {
        return apiToken;
    }

    public int getQueryPort ()
    {
        return queryPort;
    }

    public int getHttpPort ()
    {
        return httpPort;
    }

    public int getServerPort ()
    {
        return serverPort;
    }

    public boolean isEnableTelnet ()
    {
        return enableTelnet;
    }

    public boolean isEnableRestApi ()
    {
        return enableRestApi;
    }

    public boolean isEnableLogging ()
    {
        return enableLogging;
    }
}
