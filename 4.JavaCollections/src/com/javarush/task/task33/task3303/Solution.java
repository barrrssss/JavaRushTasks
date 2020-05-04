package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        File file = new File(fileName);

        ObjectMapper objectMapper = new ObjectMapper();
        T t = objectMapper.readValue(file, clazz);

        return t;
    }

    public static void main(String[] args) {



    }
}
