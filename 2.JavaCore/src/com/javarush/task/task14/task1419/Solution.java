package com.javarush.task.task14.task1419;

import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try{
            int[] arr = new int[10];
            arr[11] = 1;
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Integer.parseInt("Тринадцать");
        }
        catch (Exception e){
            exceptions.add(e);
        }
        try {
            throw new SecurityException();
        }
        catch (Exception e){
            exceptions.add(e);
        }
        try {
            int a = 1;
            Integer b;
            if (a == 1) {
                b = null;
                int c = b;
                System.out.println(c);
            }
        }
        catch (Exception e){
            exceptions.add(e);
        }
        try {
            throw new NoSuchMethodException();
        }
        catch (Exception e){
            exceptions.add(e);
        }
        try {
            throw new ReflectiveOperationException();
        }
        catch (Exception e){
            exceptions.add(e);
        }
        try {
            throw new IllegalMonitorStateException();
        }
        catch (Exception e){
            exceptions.add(e);
        }
        try {
            throw new StringIndexOutOfBoundsException();
        }
        catch (Exception e){
            exceptions.add(e);
        }
        try {
            throw new InstantiationException();
        }
        catch (Exception e){
            exceptions.add(e);
        }

        //напишите тут ваш код

    }
}
