package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            Set wordsSet = new FilterHashSet();

            while (bufferedReader.ready()){
                String line = bufferedReader.readLine();
                if (line.startsWith("\uFEFF")) line = line.substring(1);

                String[] words = line.split(" ");
                for (String word : words){
                    wordsSet.add(word);
                }
            }
        }

        for (Pair pair : result){
            System.out.println(pair.first + " " + pair.second);
        }

    }

    public static class FilterHashSet extends HashSet<String>{
        @Override
        public boolean add(String s) {
            if (contains(s)){
                result.add(new Pair(s, s));
                remove(s);
                return false;
            }

            StringBuilder stringBuilder = new StringBuilder(s);
            stringBuilder.reverse();
            String reverse = stringBuilder.toString();
            if (contains(reverse)){
                result.add(new Pair(reverse, s));
                remove(reverse);
                return false;
            }

            return super.add(s);
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
