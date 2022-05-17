package com.mensajeria;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ServerEndpoint(value = "/chat", encoders = {EncoderMensaje.class}, decoders = {DecoderMensaje.class})
public class Chat {
    private static final List<Session> conectados = new ArrayList<>();

    @OnOpen
    public void init(Session session) {
        conectados.add(session);
    }

    @OnClose
    public void exit(Session session) {
        conectados.remove(session);
    }

    @OnMessage
    public void message(Message message) throws EncodeException, IOException {
        for(Session session : conectados) {
            session.getBasicRemote().sendObject(message);
        }
    }

}
