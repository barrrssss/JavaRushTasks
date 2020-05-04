package com.javarush.task.task20.task2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        ArrayList<Long> list = new ArrayList<>();

        for (long i = 0; i < N; i++){
            if (isNumberSuitable(i)) list.add(i);
        }

        long[] result = new long[list.size()];

        for (int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }

        return result;
    }

    public static boolean isNumberSuitable(long number){
        byte count = getCountsOfDigits(number);
        long dublicate = number;
        long ourNumber = 0;
        for (byte i = 0; i < count; i++){
//            ourNumber += Math.pow(dublicate % 10, count);
            ourNumber += getPow((int) (dublicate % 10), count);
            dublicate /= 10;
        }

        return number == ourNumber;
    }

    public static int getPow(int a, byte b){
        int result = a;
        for (byte i = 1; i < b; i++) {
            a *= result;
        }
        return a;
    }

    public static byte getCountsOfDigits(long number) {
        byte count = (byte) ((number == 0) ?  1 : 0);
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        long [] result = getNumbers(Long.MAX_VALUE);
        long [] result1 = getNumbers(100);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result1));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s = reader.readLine();
            Date startDate = new Date();
            long[] numbers = getNumbers(Long.parseLong(s));
            for (long number : numbers){
                System.out.println(number);
            }
            Date endDate = new Date();
            System.out.println("Колличество найденых чисел : " + numbers.length);
            System.out.println("Время : " + (endDate.getTime() - startDate.getTime()) + " мс");
            System.out.println("Память: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1000000 + " MB");
        }


    }
}
