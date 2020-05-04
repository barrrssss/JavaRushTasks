package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String propertiesFileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(propertiesFileName);
        load(fileInputStream);

    }

    public void save(OutputStream outputStream) throws Exception {
        Properties properties = new Properties();

        for (Map.Entry<String, String> entry : Solution.properties.entrySet()){
            properties.setProperty(entry.getKey(), entry.getValue());
        }
        properties.store(outputStream, "");

    }

    public void load(InputStream inputStream) throws Exception {
        Properties properties = new Properties();
        properties.load(inputStream);

        for (Map.Entry<Object, Object> entry : properties.entrySet()){
            Solution.properties.put((String) entry.getKey(),(String) entry.getValue());
        }
    }

    public static void main(String[] args) throws Exception {
    }
}
