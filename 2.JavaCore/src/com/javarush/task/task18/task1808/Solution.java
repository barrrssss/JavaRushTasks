package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Name = reader.readLine();
        String file2Name = reader.readLine();
        String file3Name = reader.readLine();

        reader.close();

        FileInputStream inputStream = new FileInputStream(file1Name);

        int file1Size = inputStream.available();
        int file2Size;

        if (file1Size % 2 == 0){
            file2Size = file1Size / 2;
        }
        else {
            file2Size = file1Size / 2 + 1;
        }

        FileOutputStream outputStream1 = new FileOutputStream(file2Name);
        FileOutputStream outputStream2 = new FileOutputStream(file3Name);

        while ((file1Size - file2Size) < inputStream.available()){
            int data = inputStream.read();
            outputStream1.write(data);
        }

        while (inputStream.available() > 0){
            int data = inputStream.read();
            outputStream2.write(data);
        }

        inputStream.close();
        outputStream1.close();
        outputStream2.close();

    }
}
