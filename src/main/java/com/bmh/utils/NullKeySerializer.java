package com.bmh.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Map;

public class NullKeySerializer extends StdSerializer<Map<?, ?>> {
    public NullKeySerializer() {
        this(null);
    }

    public NullKeySerializer(Class<Map<?, ?>> t) {
        super(t);
    }

    @Override
    public void serialize(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        // Implémentez votre logique de sérialisation ici
    }
}
