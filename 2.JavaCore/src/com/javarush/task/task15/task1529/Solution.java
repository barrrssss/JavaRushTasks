package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    public static CanFly result;
    
    static {
        reset();
    }

    public static void reset() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();

            if (s.equals("helicopter")){
                result = new Helicopter();
            }
            else if (s.equals("plane")){
                int passengersCount = Integer.parseInt(reader.readLine());

                result = new Plane(passengersCount);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //add your code here - добавьте код тут
    }
}
