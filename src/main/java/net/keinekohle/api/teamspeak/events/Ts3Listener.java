package net.keinekohle.api.teamspeak.events;

public interface Ts3Listener
{
    void clientConnect (ClientConnectedEvent clientConnectedEvent);
    void clientDisconnect ();
    void clientJointChannel ();
    void clientMoved ();
    void clientMovedOtherClient ();
}
