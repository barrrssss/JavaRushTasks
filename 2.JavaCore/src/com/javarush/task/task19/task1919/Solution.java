package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(new File(args[0]));
        Map<String, Double> map = new TreeMap<>();
        StringBuilder stringBuilder = new StringBuilder();

        while (fileReader.ready()){
            char data = (char) fileReader.read();
            stringBuilder.append(data);
        }
        fileReader.close();

        String[] lines = stringBuilder.toString().split("\n");
        if (lines[0].startsWith("\uFEFF")){
            lines[0] = lines[0].substring(1);
            }

        for (String line : lines){
            String[] arguments = line.split(" ");
            double value = Double.parseDouble(arguments[1]);
            Double oldValue = map.putIfAbsent(arguments[0], value);
            if (oldValue != null) {
                map.replace(arguments[0], value + oldValue);
            }
        }

        for (Map.Entry<String, Double> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
