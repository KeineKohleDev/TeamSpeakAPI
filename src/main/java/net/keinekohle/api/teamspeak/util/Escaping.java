package net.keinekohle.api.teamspeak.util;

public class Escaping
{
    public static String escape (String str)
    {
        return str.replace("\\", "\\\\")
                  .replace("/", "\\/")
                  .replace(" ", "\\s")
                  .replace("|", "\\p")
                  .replace(String.valueOf((char) 7), "\\a")
                  .replace("\b", "\\b")
                  .replace("\f", "\\f")
                  .replace("\n", "\\n")
                  .replace("\r", "\\r")
                  .replace("\t", "\\t")
                  .replace(String.valueOf((char) 11), "\\v");
    }

    public static String unEscape (String str)
    {
        return str.replace("\\\\", "\\")
                .replace("\\/", "/")
                .replace("\\s", " ")
                .replace("\\p", "|")
                .replace("\\a", String.valueOf((char) 7))
                .replace("\\b", "\b")
                .replace("\\f", "\f")
                .replace("\\n", "\n")
                .replace("\\r", "\r")
                .replace("\\t", "\t")
                .replace("\\v", String.valueOf((char) 11));
    }
}
