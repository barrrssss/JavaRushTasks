package com.javarush.task.task19.task1926;

import java.io.*;
/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while (bufferedReader.ready()){
            StringBuilder stringBuilder = new StringBuilder(bufferedReader.readLine());
            System.out.println(stringBuilder.reverse());
        }
        bufferedReader.close();
    }
}
