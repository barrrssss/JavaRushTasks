package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileName);
        StringBuffer stringBuffer = new StringBuffer();
        while (fileReader.ready()){
            char data = (char) fileReader.read();
            stringBuffer.append(data);
        }
        fileReader.close();

        String text = stringBuffer.toString();
        String[] words = text.split("\\W+");

        int count = 0;
        for (String s:words){
            if (s.equals("world")){
                count++;
            }
        }

        System.out.println(count);


    }

}
