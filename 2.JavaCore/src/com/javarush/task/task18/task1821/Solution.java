package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/


import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] symbols = new int[128];

        FileInputStream inputStream = new FileInputStream(args[0]);

        while (inputStream.available() > 0){
            int data = inputStream.read();
            symbols[data]++;
        }
        inputStream.close();

        for (int i = 0; i < symbols.length; i++){
            if (symbols[i] != 0){
                System.out.println(String.format("%s %s", (char) i, symbols[i]));
            }
        }

    }
}
