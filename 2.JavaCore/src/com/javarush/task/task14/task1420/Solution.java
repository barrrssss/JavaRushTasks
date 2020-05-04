package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a, b;

            a = Integer.parseInt(reader.readLine());
            if (a <= 0){
                throw new IllegalArgumentException();
            }

            b = Integer.parseInt(reader.readLine());
            if (b <= 0){
                throw new IllegalArgumentException();
            }

            System.out.println(greatestCommonDivisor(a, b));



    }

    public static int greatestCommonDivisor(int a, int b){
        int c;
        if (a > b){
            c = b;
        }
        else {
            c = a;
        }

        for (int i = c; i >= 1; i--){
            if (a % i == 0 && b % i == 0){
                c = i;
                break;
            }
        }

        return c;
    }
}
