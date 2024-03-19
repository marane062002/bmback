package com.bmh.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class JacksonConfiguration {

    /*@Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Désactiver l'écriture des valeurs null dans les cartes
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

        // Enregistrer le sérialiseur NullKeySerializer pour les clés null dans les cartes
        SimpleModule module = new SimpleModule();
        module.addSerializer(new TypeReference<Map<?, ?>>() {}, new NullKeySerializer());
        objectMapper.registerModule(module);

        return objectMapper;
    }*/


}
