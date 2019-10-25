package com.phablo.tassio.salao.api.utils;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public abstract class ObjectMapperUtil {

    private ObjectMapperUtil() {
    }

    private static ObjectMapper MAPPER = getMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true).setSerializationInclusion(JsonInclude.Include.NON_NULL);

    public static <T> T toObject(final String json, Class<T> clazz) {
        try {
            if (StringUtils.isBlank(json)) {
                return clazz.newInstance();
            }
            return MAPPER.readValue(json, clazz);
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toJson(final Object json) {

        try {
            return MAPPER.writeValueAsString(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static <T> T toObject(final String json, TypeReference<T> type) {

        try {
            if (StringUtils.isBlank(json)) {
                throw new RuntimeException();
            }

            return MAPPER.readValue(json, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ObjectMapper getMapper() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return mapper;
    }

}
