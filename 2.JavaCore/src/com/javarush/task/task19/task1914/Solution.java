package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        testString.printSomething();

        String text = outputStream.toString();
        System.setOut(consoleStream);
        
        String[] arguments = text.split(" ");
        
        int result = 0;
        
        switch (arguments[1]){
            case "+":{
                result = Integer.parseInt(arguments[0]) + Integer.parseInt(arguments[2]);
                break;
            }
            case "-":{
                result = Integer.parseInt(arguments[0]) - Integer.parseInt(arguments[2]);
                break;
            }
            case "*":{
                result = Integer.parseInt(arguments[0]) * Integer.parseInt(arguments[2]);
                break;
            }
        }
        
        System.out.println(text.replaceAll("\r\n","") + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

