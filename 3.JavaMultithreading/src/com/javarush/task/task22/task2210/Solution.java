package com.javarush.task.task22.task2210;

import java.util.*;
import java.util.function.Consumer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        IterableStringTokenizer iterableStringTokenizer = new IterableStringTokenizer("Hello world", " ");

        for (String s : iterableStringTokenizer){
            System.out.println(s);
        }
        for (String s : iterableStringTokenizer){
            System.out.println(s);
        }

    }

    public static String[] getTokens(String query, String delimiter) {
        IterableStringTokenizer iterableStringTokenizer = new IterableStringTokenizer(query, delimiter);

        List<String> list = new ArrayList<>();
        iterableStringTokenizer.forEach(list::add);

        String[] arr = new String[list.size()];

        return list.toArray(arr);
    }

    public static class IterableStringTokenizer extends StringTokenizer implements Iterable<String> {
        private StringTokenizer instance;

        public IterableStringTokenizer(String str, String delim, StringTokenizer instance) {
            super(str, delim);
            this.instance = instance;
        }

        public IterableStringTokenizer(String str, String delim) {
            super(str, delim);
        }

        @Override
        public Iterator<String> iterator() {
            return new Itr();
        }

        @Override
        public void forEach(Consumer<? super String> action) {
            for (String s : this){
                action.accept(s);
            }
        }

        @Override
        public Spliterator<String> spliterator() {
            return Spliterators.spliterator(iterator(), countTokens(), 0);
        }

        private class Itr implements Iterator<String>{

            @Override
            public boolean hasNext() {
                return hasMoreTokens();
            }

            @Override
            public String next() {
                return nextToken();
            }
        }
    }


}
