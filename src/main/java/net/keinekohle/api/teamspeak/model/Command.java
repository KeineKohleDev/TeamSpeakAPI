package net.keinekohle.api.teamspeak.model;

import com.google.gson.JsonObject;

import java.util.Arrays;
import java.util.UUID;

public class Command
{
    private final UUID COMMAND_UUID = UUID.randomUUID();
    private String name;
    private String[] args;
    private JsonObject response;
    private long createdTime = System.nanoTime();
    private long sentTime;
    private long receivedTime;

    public Command (String name, String[] args)
    {
        this.name = name;
        this.args = args;
    }

    @Override
    public String toString ()
    {
        StringBuilder stringBuilder = new StringBuilder(name);
        Arrays.stream(args).forEach(arg -> stringBuilder.append(" ").append(arg));
        return stringBuilder.toString();
    }

    public void setSentTime ()
    {
        this.sentTime = System.nanoTime();
    }

    public void setReceivedTime ()
    {
        this.receivedTime = System.nanoTime();
    }

    public void setResponse (JsonObject response)
    {
        this.response = response;
    }

    public UUID getCOMMAND_UUID ()
    {
        return COMMAND_UUID;
    }
}
