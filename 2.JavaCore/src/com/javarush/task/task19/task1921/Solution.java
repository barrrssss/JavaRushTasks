package com.javarush.task.task19.task1921;

import java.io.*;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, InterruptedException {
        Map<String, Double> map = new TreeMap<>();
        StringBuilder stringBuilder = new StringBuilder();
//        FileReader fileReader = new FileReader(new File(args[0]));
//
//        while (fileReader.ready()){
//            char data = (char) fileReader.read();
//            stringBuilder.append(data);
//        }
//        fileReader.close();
//
//        String[] lines = stringBuilder.toString().split("\r\n");
//        if (lines[0].startsWith("\uFEFF")){
//            lines[0] = lines[0].substring(1);
//        }

        List<String> lines = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            lines.add(line);
        }
        if (lines.get(0).startsWith("\uFEFF")){
            lines.set(0, lines.get(0).substring(1));
        }

        for (String line : lines){
            String arguments[] = line.split(" ");
            StringBuilder nameBuilder = new StringBuilder();
            List<Integer> listData = new ArrayList<>(3);

            for (String argument : arguments){
                if (argument.matches("\\D*")){
                    nameBuilder.append(argument).append(' ');
                }
                else {
                    listData.add(Integer.parseInt(argument));
                }
            }

            String name = nameBuilder.toString().trim();
            Date date = new Date(listData.get(2) - 1900, listData.get(1) - 1, listData.get(0));

            PEOPLE.add(new Person(name, date));
        }

        Thread.sleep(1000);
    }

}
