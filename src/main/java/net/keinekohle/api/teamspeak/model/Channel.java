package net.keinekohle.api.teamspeak.model;

import com.google.gson.JsonObject;
import net.keinekohle.api.teamspeak.comp.Ts3Api;
import net.keinekohle.api.teamspeak.util.ChannelType;

import java.util.ArrayList;
import java.util.List;

public class Channel
{
    private String channelName;
    private int channelOrder;
    private int channelID;
    private int parentChannelID;
    private int totalClients;
    private ChannelType channelType;


    public Channel (JsonObject json)
    {
        this.channelName = json.get("channel_name").getAsString();
        this.channelOrder = json.get("channel_order").getAsInt();
        this.channelID = json.get("cid").getAsInt();
        this.parentChannelID = json.get("pid").getAsInt();
        this.totalClients = json.get("total_clients").getAsInt();
        if (this.channelName.startsWith("[cspacer"))
            this.channelType = ChannelType.CSPACER;
        else if (this.channelName.startsWith("[spacer"))
            this.channelType = ChannelType.SPACER;
        else
            this.channelType = ChannelType.NORMAL;
    }
    public Channel (Ts3Api ts3Api, String channelName)
    {

    }

    public Channel (Ts3Api ts3Api, int channelID)
    {
    }

    @Override
    public String toString ()
    {
        return "channel_name: " + this.channelName + "\nchannel_order: " + this.channelOrder + "\ncid: " + this.channelID + "\npid: " + this.parentChannelID + "\ntotal_client: " + this.totalClients;
    }
}
