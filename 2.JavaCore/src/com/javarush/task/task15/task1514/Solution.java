package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<>();
    static {
        labels.put(1d, "Вадик");
        labels.put(2d, "Даша");
        labels.put(3d, "Женя");
        labels.put(4d, "Наталья");
        labels.put(5d, "Анатолий");
    }

    public static void main(String[] args) {

        System.out.println(labels);

    }
}
