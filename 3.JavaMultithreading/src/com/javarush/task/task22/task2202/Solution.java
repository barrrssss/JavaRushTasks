package com.javarush.task.task22.task2202;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string){
        if (string == null) throw new TooShortStringException();

        Pattern pattern = Pattern.compile("(?<= ).*? .*? .*? .*?(?=$| )");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find() == false){
            throw new TooShortStringException();
        }

        String result = string.substring(matcher.start(), matcher.end());

        return result;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
