package com.javarush.task.task33.task3312;

import com.fasterxml.jackson.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    public List<Animal> animals = new ArrayList<>();

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value=Cat.class),
            @JsonSubTypes.Type(value=Dog.class)
    })
    public static class Animal {
        public Animal(){};

        @JsonCreator
        public Animal(@JsonProperty("name") String name) {
            this.name = name;
        }

        public String name;

        @Override
        public String toString() {
            Class clazz = getClass();
            String result = clazz.getSimpleName() + " ";

            Field[] fields = clazz.getFields();

            for (Field field : fields){
                try {
                    result += field.getName() + ":" + field.get(this).toString() + "    ";
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            return result;
        }
    }

    @JsonTypeName("dog")
    public static class Dog extends Animal {
        public double barkVolume;

        @JsonCreator
        public Dog(@JsonProperty("name") String name) {
            super(name);
        }
    }

    @JsonTypeName("cat")
    public static class Cat extends Animal {
        public boolean likesCream;
        public int lives;

        @JsonCreator
        public Cat(@JsonProperty("name") String name) {
            super(name);
        }

    }
}