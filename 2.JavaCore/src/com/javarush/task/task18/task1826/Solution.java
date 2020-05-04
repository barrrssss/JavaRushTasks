package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(args[1]));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(args[2]));

        switch (args[0]){
            case "-e":{
                while (inputStream.available() > 0){
                    int data = inputStream.read();
                    int modifyData = data ^ 1;

                    outputStream.write(modifyData);
                }
                break;
            }
            case "-d":{
                while (inputStream.available() > 0){
                    int modifyData = inputStream.read();
                    int data = modifyData ^ 1;

                    outputStream.write(data);
                }
            }
        }
        inputStream.close();
        outputStream.close();
    }

}
