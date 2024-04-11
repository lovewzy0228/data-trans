package com.psbc.data.trans.configuration.web;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author zhenyu.wu
 * @date 2024/4/11 19:14
 */
@Configuration
public class CustomDateConverterConfig {

    /**
     * 入参-形参、@RequestParam和@PathVariable时候-字符串转Date相关类
     */
    @Component
    public static class LocalDateConvert implements Converter<String, LocalDate> {
        @Override
        public LocalDate convert(String timestamp) {
            return DateUtil.date(Long.parseLong(timestamp)).toLocalDateTime().toLocalDate();
        }
    }

    /**
     * 入参-形参、@RequestParam和@PathVariable时候-字符串转Date相关类
     */
    @Component
    public static class LocalDateTimeConvert implements Converter<String, LocalDateTime> {
        @Override
        public LocalDateTime convert(String timestamp) {
            return DateUtil.date(Long.parseLong(timestamp)).toLocalDateTime();
        }
    }

    /**
     * 入参-形参、@RequestParam和@PathVariable时候-字符串转Date相关类
     */
    @Component
    public static class DateConvert implements Converter<String, Date> {
        @Override
        public Date convert(String timestamp) {
            return DateUtil.date(Long.parseLong(timestamp)).toJdkDate();
        }
    }

    /**
     * 反序列化LocalDateTime
     */
    @Component
    public static class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
        @Override
        public LocalDateTime deserialize(JsonParser p, DeserializationContext deserializationContext) throws IOException {
            Long timestamp = p.getLongValue();
            Instant instant = Instant.ofEpochMilli(timestamp);
            return LocalDateTime.ofInstant(instant, ZoneId.of("+8"));
        }
    }

    /**
     * 序列化LocalDateTime为时间戳
     */
    @Component
    public static class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
        @Override
        public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeNumber(value.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
        }
    }

    /**
     * 反序列化LocalDate
     */
    @Component
    public static class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
        @Override
        public LocalDate deserialize(JsonParser p, DeserializationContext deserializationContext) throws IOException {
            Long timestamp = p.getLongValue();
            Instant instant = Instant.ofEpochMilli(timestamp);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("+8"));
            LocalDate localDate = localDateTime.toLocalDate();
            return localDate;
        }
    }

    /**
     * 序列化LocalDate为时间戳
     */
    @Component
    public static class LocalDateSerializer extends JsonSerializer<LocalDate> {
        @Override
        public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeNumber(value.atStartOfDay().toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
        }
    }

    /**
     * Json序列化和反序列化转换器，用于转换Post请求体中的json以及将我们的对象序列化为返回响应的json
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        //LocalDateTime系列序列化和反序列化模块，继承自jsr310，我们在这里修改了日期格式
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        // LocalDateTime
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        // LocalDate
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer());
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());

        objectMapper.registerModule(javaTimeModule);
        return objectMapper;
    }
}
