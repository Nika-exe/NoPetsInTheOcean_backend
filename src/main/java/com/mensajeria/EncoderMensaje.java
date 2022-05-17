package com.mensajeria;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonWriter;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import java.io.IOException;
import java.io.Writer;

public class EncoderMensaje implements Encoder.TextStream<Message>{
    @Override
    public void encode(Message message, Writer writer) throws EncodeException, IOException {
        JsonObject json = Json.createObjectBuilder()
                .add("nombre", message.getNombre())
                .add("mensaje", message.getMensaje())
                .build();
        try (JsonWriter jsonWriter = Json.createWriter(writer)) {
            jsonWriter.writeObject(json);
        }
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
