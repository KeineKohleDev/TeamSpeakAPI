package net.keinekohle.api.teamspeak.util;

import com.google.gson.JsonObject;

import java.util.Arrays;

public class ResponseParser
{
    public static void pars (JsonObject jsonObject, String raw)
    {
        if (raw.startsWith("error"))
        {
            raw = raw.replace("error ", "");
            String[] splits = raw.split(" ");
            jsonObject.get("status").getAsJsonObject().addProperty("code", splits[0].substring(splits[0].indexOf("=") + 1));
            jsonObject.get("status").getAsJsonObject().addProperty("message", Escaping.unEscape(splits[1].substring(splits[1].indexOf("=") + 1)));
        }
        else
        {
            String[] firstLevel = raw.split("\\|");
            Arrays.stream(firstLevel).forEach(row -> Arrays.stream(row.split(" ")).forEach(item ->
            {
                JsonObject temp = new JsonObject();
                temp.addProperty(item.substring(0, item.indexOf("=")), item.substring(item.indexOf("=") + 1));
                jsonObject.get("body").getAsJsonArray().add(temp.getAsJsonObject());
            }));
        }
    }
}
