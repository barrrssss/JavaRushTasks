package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

        MyEntry<String, Double>[] arr = new MyEntry[map.size()];

        int i = 0;
        for (Map.Entry<String, Double> entry : map.entrySet()){
            arr[i] = new MyEntry<>(entry.getKey(), entry.getValue());
            i++;
        }

        double maxValue = arr[0].getValue();
        for (i = 1; i < arr.length; i++){
            if (arr[i].getValue() > maxValue){
                maxValue = arr[i].getValue();
            }
        }

        for (MyEntry<String, Double> entry : arr){
            if (entry.getValue() == maxValue){
                System.out.println(entry.getKey());
            }
        }

    }

    static class MyEntry<P, T>{
        private P key;
        private T value;

        public MyEntry(P key, T value) {
            this.key = key;
            this.value = value;
        }

        public P getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

        public void setKey(P key) {
            this.key = key;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}
