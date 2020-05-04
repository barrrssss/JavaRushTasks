package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        String name = args[0];
        int count = 0;

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(name));

        while (inputStream.available() > 0){
            char character = (char) inputStream.read();

            for (char i = 'a'; i <= 'z'; i++){
                if (character == i || Character.toLowerCase(character) == i){
                    count++;
                }
            }
        }

        System.out.println(count);

        inputStream.close();

    }
}
