package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(file));

        String s;
        while ((s = reader1.readLine()) != null){
            if (s.startsWith(args[0] + " ")) break;
        }
        reader1.close();

        System.out.println(s);
    }
}
