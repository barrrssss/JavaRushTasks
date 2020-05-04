package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.management.ObjectName;
import java.io.IOException;

/* 
Конвертация из одного класса в другой используя JSON
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        System.out.println(s.getClass().toString());
        First f = (First) convertOneToAnother(new Second(), First.class);
        System.out.println(f.getClass().toString());
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(MapperFeature.USE_ANNOTATIONS);

        String json = objectMapper.writeValueAsString(one);
        Object object = objectMapper.readValue(json, resultClassObject);

        return object;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))
    public static class First {
        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))
    public static class Second {
        public int i;
        public String name;
    }
}
