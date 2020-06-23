package com.javarush.task.task36.task3602;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

/*
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class result = null;
        Class[] classes = Collections.class.getDeclaredClasses();

        for (Class clazz : classes){
            if (clazz.getSimpleName().equals("EmptyList")) {
                result = clazz;
            }
        }

        return result;
    }
}
