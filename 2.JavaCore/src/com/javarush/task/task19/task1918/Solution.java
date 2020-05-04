package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(new File(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()){
            int data = fileReader.read();
            char symbol = (char) data;
            stringBuilder.append(symbol);
        }
        String text = stringBuilder.toString();

        String startTeg = String.format("<%s", args[0]);
        String endTeg = String.format("</%s>", args[0]);

        LinkedList<Integer> openTeg = new LinkedList<>();
        LinkedList<Integer> closeTeg = new LinkedList<>();

        Pattern pattern = Pattern.compile(startTeg + "|" + endTeg);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            if (matcher.group().equals(startTeg)){
                openTeg.add(matcher.start());
            }
            else {
                closeTeg.add(matcher.end());
            }
            if (openTeg.size() == closeTeg.size()){
                System.out.println(text.substring(openTeg.getFirst(), closeTeg.getLast()));
                openTeg.clear();
                closeTeg.clear();
            }
        }
        fileReader.close();
    }
}
