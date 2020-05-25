package com.javarush.task.task22.task2212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        return telNumber.matches("(?=^[^()-]*(\\(\\d{3}\\))?[^()]*$)(?=^[^-]*([^-]*-[^-]*){0,2}$)(?!--)(((?=^(\\D?\\d){12}$)^\\+.*)|((?=^(\\D?\\d){10}$)^[\\d(].*))");
    }

    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String s;
            while ((s = bufferedReader.readLine()) != null){
                System.out.println(checkTelNumber(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
