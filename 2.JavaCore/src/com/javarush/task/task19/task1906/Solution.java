package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);

        boolean arg = false;
        while (fileReader.ready()){
            int data = fileReader.read();

            if (arg){
                fileWriter.write(data);
            }

            arg = !arg;
        }
        fileReader.close();
        fileWriter.close();
    }
}
