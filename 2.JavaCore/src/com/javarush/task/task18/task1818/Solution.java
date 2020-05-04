package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName2);
        FileOutputStream outputStream = new FileOutputStream(fileName1);

        while (inputStream.available() > 0){
            int data = inputStream.read();
            outputStream.write(data);
        }

        inputStream.close();

        FileInputStream inputStream2 = new FileInputStream(fileName3);

        while (inputStream2.available() > 0){
            int data = inputStream2.read();
            outputStream.write(data);
        }

        inputStream2.close();
        outputStream.close();
    }
}
