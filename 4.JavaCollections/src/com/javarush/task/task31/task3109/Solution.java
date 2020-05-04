package com.javarush.task.task31.task3109;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Path path = Paths.get(fileName);
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(path.toFile())) {

            if (path.getFileName().toString().endsWith(".xml")){
                properties.loadFromXML(fileInputStream);
            } else {
                properties.load(fileInputStream);
            }
        } catch (Exception e) {
            properties = new Properties();
        } finally {
            return properties;
        }
    }
}
