package com.javarush.task.task35.task3509;

import java.util.*;

/*
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {

//        newHashMap(new ArrayList<String>(), new ArrayList<Integer>()).

    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        return new HashSet<>(Arrays.asList(elements));
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //напишите тут ваш код
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException("Keyses size and valueses size differ");
        }

        HashMap<K, V> map = new HashMap<K, V>();

        for (int i = 0; i < keys.size(); i++){
            map.put(keys.get(i), values.get(i));
        }

        return map;
    }
}
