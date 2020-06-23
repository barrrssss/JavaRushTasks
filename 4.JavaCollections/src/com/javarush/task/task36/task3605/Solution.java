package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        TreeSet<Character> treeSet = new TreeSet<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            while (bufferedReader.ready()){
                char c = (char) bufferedReader.read();

                String s = String.valueOf(c);

                if (!s.matches("[A-Za-z]")) continue;

                treeSet.add(Character.toLowerCase(c));
            }
        }

        treeSet.stream()
                .limit(5)
                .forEach(System.out::print);
    }
}
