package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        String name = args[0];
        int count = 0;

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(name));

        int countOfAllSymbols = inputStream.available();

        while (inputStream.available() > 0){
            char character = (char) inputStream.read();

            if (character == ' '){
                count++;
            }
        }

        double ratio = ((double) count / countOfAllSymbols) * 100;

        ratio = Math.rint(100 * ratio) / 100;

        System.out.println(ratio);

        inputStream.close();

    }
}
