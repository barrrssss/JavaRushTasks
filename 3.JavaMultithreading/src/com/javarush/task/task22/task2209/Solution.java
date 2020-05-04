package com.javarush.task.task22.task2209;

import javafx.concurrent.Worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);
        List<String> cities = new ArrayList<>();

        for (String line : lines){
            if (line.startsWith("\uFEFF")) line = line.substring(1);
            String[] words = line.split(" ");
            cities.addAll(Arrays.asList(words));
        }


        //...
        StringBuilder result = getLine(cities.toArray(new String[0]));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Character.toLowerCase(o1.charAt(o1.length() - 1)) == Character.toLowerCase(o2.charAt(0))) return -1;
                if (Character.toLowerCase(o2.charAt(o2.length() - 1)) == Character.toLowerCase(o1.charAt(0))) return 1;

                return 0;
            }
        };

        LinkedList<String> list = new LinkedList<>();
        LinkedList<String> citiesList = new LinkedList<>(Arrays.asList(words));

        while (!citiesList.isEmpty()){
            for (String city : citiesList){
                if (list.isEmpty()){
                    list.add(city);
                    citiesList.remove(city);
                    break;
                }

                if (add1(city, list, comparator)) {
                    citiesList.remove(city);
                    break;
                }
            }
        }

        String result = String.join(" ", list.toArray(new String[list.size()]));
        return new StringBuilder(result);
    }

    private static boolean add1(String s, LinkedList<String> list, Comparator<String> comparator){
        if (comparator.compare(s, list.getFirst()) < 0) return list.offerFirst(s);
        if (comparator.compare(s, list.getLast()) > 0) return list.offerLast(s);

        return false;
    }
}
