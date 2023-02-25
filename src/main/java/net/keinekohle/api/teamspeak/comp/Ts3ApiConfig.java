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
    private boolean enableLogging;

    public Ts3ApiConfig ()
    {
        this.queryPort = Defaults.DEFAULT_QUERY_PORT;
        this.httpPort = Defaults.DEFAULT_HTTP_PORT;
        this.serverPort = Defaults.DEFAULT_SERVER_PORT;
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

    String getHostAddress ()
    {
        return hostAddress;
    }

    String getQueryLoginName ()
    {
        return queryLoginName;
    }

    String getQueryPassword ()
    {
        return queryPassword;
    }

    String getApiToken ()
    {
        return apiToken;
    }

    int getQueryPort ()
    {
        return queryPort;
    }

    int getHttpPort ()
    {
        return httpPort;
    }

    int getServerPort ()
    {
        return serverPort;
    }

    boolean isEnableLogging ()
    {
        return enableLogging;
    }
}
