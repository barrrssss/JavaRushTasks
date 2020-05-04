package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        reader.close();

        FileInputStream inputStream1 = new FileInputStream(fileName1);

        byte[] file1Data = new byte[inputStream1.available()];
        inputStream1.read(file1Data);

        inputStream1.close();

        FileOutputStream outputStream = new FileOutputStream(fileName1);
        FileInputStream inputStream2 = new FileInputStream(fileName2);

        while (inputStream2.available() > 0){
            int data = inputStream2.read();
            outputStream.write(data);
        }

        inputStream2.close();

        outputStream.write(file1Data);

        outputStream.close();

    }
}