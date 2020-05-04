package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        List<String> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();

            if (checkLine(line)){
                list.add(line);
            }
        }
        bufferedReader.close();

        for (String string : list){
            System.out.println(string);
        }

    }

    public static boolean checkLine(String line){
        int i = 0;
        boolean result;
        String[] wordsFromLine = line.split(" ");

        for (String word : words){
            for (String wordFromLine : wordsFromLine){
                if (word.equals(wordFromLine)){
                    i++;
                }
            }
        }

        if (i == 2){
            result = true;
        }
        else {
            result = false;
        }

        return result;
    }
}
