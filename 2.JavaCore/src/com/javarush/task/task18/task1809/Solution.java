package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Name = reader.readLine();
        String file2Name = reader.readLine();

        reader.close();

        FileInputStream inputStream = new FileInputStream(file1Name);

        byte[] buffer = new byte[inputStream.available()];

        inputStream.read(buffer);
        inputStream.close();


        FileOutputStream outputStream = new FileOutputStream(file2Name);

        for (int i = buffer.length - 1; i >= 0; i--){
            outputStream.write(buffer[i]);
        }

        outputStream.close();

    }
}
