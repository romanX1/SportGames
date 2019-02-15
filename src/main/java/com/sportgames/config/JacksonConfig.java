package com.sportgames.config;

import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sun.istack.internal.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.Assert;
import org.springframework.web.socket.sockjs.frame.AbstractSockJsMessageCodec;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class JacksonConfig{

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        ObjectMapper objectMapper=new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        objectMapper.registerModule(javaTimeModule);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return new MappingJackson2HttpMessageConverter(objectMapper);
    }
//
//    public JacksonConfig() {
//        this.objectMapper = Jackson2ObjectMapperBuilder.json().build();
//    }
//
//    public JacksonConfig(ObjectMapper objectMapper) {
//        Assert.notNull(objectMapper, "ObjectMapper must not be null");
//        this.objectMapper = objectMapper;
//    }
//
//    @Override
//    @Nullable
//    public String[] decode(String content) throws IOException {
//        return this.objectMapper.readValue(content, String[].class);
//    }
//
//    @Override
//    @Nullable
//    public String[] decodeInputStream(InputStream content) throws IOException {
//        return this.objectMapper.readValue(content, String[].class);
//    }
//
//    @Override
//    @SuppressWarnings("deprecation")
//    protected char[] applyJsonQuoting(String content) {
//        return JsonStringEncoder.getInstance().quoteAsString(content);
//
//    }
}
