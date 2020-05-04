package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            if (line.startsWith("\uFEFF")){
                line = line.substring(1);
            }
            String[] words = line.split(" ");

            for (String s : words){
                if (s.matches("\\d++")){
                    bufferedWriter.write(s + " ");
                }
            }
        }
        bufferedReader.close();
        bufferedWriter.close();


    }
}
