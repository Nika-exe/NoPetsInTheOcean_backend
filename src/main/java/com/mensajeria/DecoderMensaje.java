package com.mensajeria;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.IOException;
import java.io.Reader;

public class DecoderMensaje implements Decoder.TextStream<Message>{
    @Override
    public Message decode(Reader reader) throws DecodeException, IOException {
        Message message = new Message();
        try (JsonReader jsonReader = Json.createReader(reader)) {
            JsonObject json = jsonReader.readObject();
            message.setNombre(json.getString("nombre"));
            message.setMensaje(json.getString("mensaje"));
        }
        return message;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
