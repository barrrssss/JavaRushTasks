package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String url = reader.readLine();
        String parametr;
        String obj = "";
        int firstIndex = url.indexOf('?');
        int lastIndex = url.indexOf('&', firstIndex);
        int index;

        while (firstIndex != -1){

            if (lastIndex == -1){
                parametr = url.substring(firstIndex + 1);
            }
            else {
                parametr = url.substring(firstIndex + 1, lastIndex);
            }

            if (parametr.startsWith("obj")){
                obj = parametr.substring(4);
            }

            if ((index = parametr.indexOf('=')) != -1){
                parametr = parametr.substring(0, index);
            }

            list.add(parametr);

            firstIndex = lastIndex;

            lastIndex = url.indexOf('&', firstIndex + 1);

        }

        for (int i = 0; i < list.size(); i++){
            if (i == list.size() - 1){
                System.out.println(list.get(i));
            }
            else {
                System.out.print(list.get(i) + " ");
            }
        }

        try {
            Double a = Double.parseDouble(obj);
            alert(a);
        }
        catch (Exception e){
            if (!obj.equals("")){
                alert(obj);
            }
        }


    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
