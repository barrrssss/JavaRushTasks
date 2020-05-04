package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int min = 255;
        List<Integer> list = new ArrayList<>();

        while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
            if (map.containsKey(data)){
                int count = map.get(data) + 1;
                map.replace(data, count);
            }
            else {
                map.put(data, 1);
            }
        }


        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            int value = pair.getValue();
            if (value < min) {
                min = value;
            }
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            if (min == pair.getValue()){
                list.add(pair.getKey());
            }
        }

        for (int bbyte : list){
            System.out.print(bbyte + " ");
        }

        fileInputStream.close();



    }
}
