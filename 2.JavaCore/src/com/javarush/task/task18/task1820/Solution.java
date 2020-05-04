package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream outputStream = new FileOutputStream(fileName2);

        String s = new String();

        while (inputStream.available() > 0){
            char data = (char) inputStream.read();

            if (!(data == ' ')){
                s += data;
            }
            else {
                double number = Double.parseDouble(s);
                s = new String();
                number = Math.round(number);

                String toWrite = String.valueOf((int) number) + " ";

                outputStream.write(toWrite.getBytes());
            }
        }

        inputStream.close();
        outputStream.close();

    }
}
