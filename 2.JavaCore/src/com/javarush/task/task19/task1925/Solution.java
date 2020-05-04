package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line = reader.readLine();
        reader.close();
        Pattern pattern = Pattern.compile("\\b.{7,}?\\b");
        Matcher matcher = pattern.matcher(line);
        List<String> words = new ArrayList<>();
        while (matcher.find()){
            words.add(matcher.group().trim());
        }
        FileWriter fileWriter = new FileWriter(args[1]);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        for (int i = 0; i < words.size(); i++){
            writer.write(words.get(i));
            if (i != words.size() - 1){
                writer.write(",");
            }
        }
        writer.close();
    }
}
