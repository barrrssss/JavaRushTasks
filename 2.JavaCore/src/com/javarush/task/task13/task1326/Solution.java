package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        reader.close();
        BufferedInputStream bufferedFileStream = new BufferedInputStream(new FileInputStream(filePath));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedFileStream));
        ArrayList<Integer> list = new ArrayList<>();

        String s;
        while ((s = bufferedReader.readLine()) != null){
            int a = Integer.parseInt(s);
            list.add(a);
        }

        bufferedReader.close();

        for (int i = 0; i < list.size(); i++){
            if ((list.get(i) % 2) != 0){
                list.remove(i);
                i--;
            }
        }

        Collections.sort(list);

        for (int b : list){
            System.out.println(b);
        }
    }
}
