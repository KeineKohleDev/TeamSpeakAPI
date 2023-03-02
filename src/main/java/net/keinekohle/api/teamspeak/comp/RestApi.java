package net.keinekohle.api.teamspeak.comp;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.keinekohle.api.teamspeak.model.Channel;
import net.keinekohle.api.teamspeak.model.Client;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface to the REST-Api of teamspeak
 */
public class RestApi
{
    private final Ts3Api TS3_API;
    private final String URL;
    private final static String replacer = "{replace}";

    public RestApi (Ts3Api ts3Api)
    {
        this.TS3_API = ts3Api;
        this.URL = "http://" + ts3Api.getApiConfig().getHostAddress() + ":" + ts3Api.getApiConfig().getHttpPort() + "/byport/" + ts3Api.getApiConfig().getServerPort() + "/" + replacer + "?api-key=" + ts3Api.getApiConfig().getApiToken();
    }

    private JsonObject getValue (String value)
    {
        try
        {
            InputStream inputStream =  new URL(this.URL.replace(replacer, value)).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            return JsonParser.parseReader(reader).getAsJsonObject();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
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

    public List<Channel> channelList ()
    {
        List<Channel> channels = new ArrayList<>();
        JsonObject channelList = this.getValue("channellist");
        JsonArray body = channelList.getAsJsonArray("body");
        body.asList().stream().forEach(channel -> {
            channels.add(new Channel(channel.getAsJsonObject()));
        });
        return channels;
    }
}
